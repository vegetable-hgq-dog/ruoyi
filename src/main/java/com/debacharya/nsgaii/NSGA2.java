/*
 * MIT License
 *
 * Copyright (c) 2019 Debabrata Acharya
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.debacharya.nsgaii;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * NSGA-II（Non-dominated Sorting Genetic Algorithm II）算法核心实现类，
 * 用于求解多目标优化问题，通过非支配排序和拥挤距离维护 Pareto 前沿多样性。
 * 算法流程遵循 Deb 等人提出的原始框架，包括种群初始化、快速非支配排序、
 * 拥挤距离分配、选择、交叉、变异等关键步骤。
 * 需通过 {@link Configuration} 类配置算法参数（种群大小、迭代次数、目标函数等），
 * 调用 {@link #run()} 方法启动优化过程。
 */
public class NSGA2 {

	/** 染色体1支配染色体2的判定结果 */
	public static final int DOMINANT = 1;
	/** 染色体1被染色体2支配的判定结果 */
	public static final int INFERIOR = 2;
	/** 染色体1与染色体2非支配的判定结果 */
	public static final int NON_DOMINATED = 3;

	/** 算法配置参数容器，存储种群大小、目标函数、遗传算子等关键配置 */
	private final Configuration configuration;

	/**
	 * 使用默认配置创建 NSGA2 实例，默认配置提供所有必要插件的基础实现，
	 * 适合快速验证算法功能或进行概念验证。
	 */
	public NSGA2() {
		this.configuration = new Configuration();
	}

	/**
	 * 使用用户自定义配置创建 NSGA2 实例，允许灵活设置种群参数、遗传算子、
	 * 目标函数等，是实际应用中推荐的构造方式。
	 *
	 * @param configuration 算法配置对象，需提前通过 {@link Configuration#setup()} 完成初始化
	 */
	public NSGA2(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * 执行 NSGA-II 算法的主流程，返回优化结束后的 Pareto 前沿种群。
	 * 主要步骤包括：
	 * 1. 初始化父代和子代种群
	 * 2. 迭代执行：合并种群 → 非支配排序 → 拥挤距离计算 → 选择下一代种群 → 遗传操作生成新子代
	 * 3. 满足终止条件后，提取并输出最终 Pareto 前沿
	 *
	 * @return 包含 Pareto 最优解的种群对象
	 * @throws UnsupportedOperationException 若配置未通过 {@link Configuration#setup()} 初始化
	 */
	public Population run() {

		// 校验配置是否已初始化
		if(!this.configuration.isSetup())
			throw new UnsupportedOperationException(Configuration.CONFIGURATION_NOT_SETUP + "\n" + this.configuration.toString());

		// 初始化结果报告器
		Reporter.init(this.configuration);

		// 初始化父代种群：调用配置的种群生成器，生成初始种群并预处理
		Population parent = this.preparePopulation(
				this.configuration.getPopulationProducer().produce(
						this.configuration.getPopulationSize(),
						this.configuration.getChromosomeLength(),
						this.configuration.getGeneticCodeProducer(),
						null
				)
		);

		// 初始化子代种群：通过父代种群的遗传操作（交叉、变异）生成子代并预处理
		Population child = this.preparePopulation(
				this.configuration.getChildPopulationProducer().produce(
						parent,
						this.configuration.getCrossover(),
						this.configuration.getMutation(),
						this.configuration.getPopulationSize()
				)
		);

		int generation = 0;

		// 记录第0代（初始种群）信息
		Reporter.reportGeneration(parent, child, generation, this.configuration.objectives);
		// 存储最后5代中 rank=1 的非支配解，用于最终 Pareto 前沿提取
		List<Chromosome> rank2 = new ArrayList<>();

		// 迭代进化：根据终止准则判断是否继续（当前代数 < 最大代数）
		while(configuration.getTerminatingCriterion().shouldRun(child, ++generation, this.configuration.getGenerations())) {

			// 合并父代和子代种群（规模 2N），预处理后选择 N 个个体作为新父代
			parent = this.getChildFromCombinedPopulation(
					this.preparePopulation(
							Service.combinePopulation(
									parent,
									child
							)
					)
			);

			// 通过新父代种群的遗传操作生成新一代子代（规模 N）并预处理
			child = this.preparePopulation(
					this.configuration.getChildPopulationProducer().produce(
							parent,
							this.configuration.getCrossover(),
							this.configuration.getMutation(),
							this.configuration.getPopulationSize()
					)
			);

			// 收集最后5代的非支配解（rank=1），用于后续去重和前沿构建
			List<Chromosome> populace = child.getPopulace();
			if (generation >= this.configuration.getGenerations() -5){
				boolean rank0 = true;
				while (rank0){
					for (Chromosome chromosome : populace) {
						if (chromosome.getRank() == 1) {
							rank2.add(chromosome);
						} else {
							break; // 种群已按 rank 排序，遇到非 rank=1 个体即停止
						}
					}
					rank0 = false;
				}
			}

			// 记录当前代的种群信息（父代、子代、目标函数值等）
			Reporter.reportGeneration(parent, child, generation, this.configuration.objectives);
		}

		// 从收集的最后5代非支配解中提取最终 Pareto 前沿
		Population population = preparePopulation(new Population(rank2));
		List<Chromosome> populace = population.getPopulace();
		List<Chromosome> rank1 = new ArrayList<>();
		boolean rank = true;
		while (rank){
			for (Chromosome chromosome : populace) {
				if (chromosome.getRank() == 1) {
					rank1.add(chromosome); // 仅保留 rank=1 的非支配解
				} else {
					break;
				}
			}
			rank = false;
		}

		// 按第一个目标函数值升序排序 Pareto 前沿，便于结果分析
		Collections.sort(rank1, new Comparator<Chromosome>() {
			@Override
			public int compare(Chromosome o1, Chromosome o2) {
				return Double.compare(o1.getObjectiveValue(0), o2.getObjectiveValue(0));
			}
		});

		// 去除前沿中的重复染色体（基于遗传编码）
		List<Chromosome> ranks = deleteDuplicate(rank1);
		// 输出去重后的 Pareto 前沿个体详情
		for (Chromosome chromosome : ranks) {
			Reporter.reportChromosome1(chromosome);
		}
		// 生成最终结果报告
		Reporter.terminate(new Population(rank1), this.configuration.objectives);
		if(Reporter.autoTerminate)
			Reporter.commitToDisk();

		return child;
	}

	/**
	 * 对种群进行预处理，为遗传操作和选择做准备，依次执行：
	 * 1. 计算所有染色体的目标函数值
	 * 2. 执行快速非支配排序，为染色体分配 rank（非支配层级）
	 * 3. 计算染色体的拥挤距离，维持种群多样性
	 * 4. 按 rank 升序排序种群（同 rank 个体顺序由拥挤距离决定）
	 *
	 * @param population 待处理的种群对象（会被直接修改）
	 * @return 处理后的种群对象（与输入为同一实例）
	 */
	public Population preparePopulation(Population population) {
		// 计算目标函数值：根据配置的目标函数列表评估每个染色体
		Service.calculateObjectiveValues(population, this.configuration.objectives);
		// 快速非支配排序：将种群划分为不同非支配层级
		this.fastNonDominatedSort(population);
		// 拥挤距离分配：计算每个染色体的拥挤度，用于同层级个体选择
		this.crowdingDistanceAssignment(population);
		// 按 rank 升序排序种群，确保非支配层级高的个体优先被选择
		population.getPopulace().sort(Comparator.comparingInt(Chromosome::getRank));

		return population;
	}

	/**
	 * 从合并后的 2N 种群中选择 N 个个体作为下一代父代，实现精英保留策略：
	 * 1. 按 rank 升序排序合并种群
	 * 2. 依次选择完整非支配层，直至累计数量超过 N
	 * 3. 对最后一个不完整层，按拥挤距离降序选择剩余个体
	 *
	 * @param combinedPopulation 父代与子代合并后的种群（规模 2N）
	 * @return 选择出的下一代父代种群（规模 N）
	 */
	public Population getChildFromCombinedPopulation(Population combinedPopulation) {

		// 确定需要考虑的最后一个非支配层（第 N 个个体所在的层级）
		int lastFrontToConsider = combinedPopulation.get(this.configuration.getPopulationSize() - 1).getRank();
		List<Chromosome> childPopulace = new ArrayList<>();

		// 若第 N 个和第 N+1 个个体同属一个非支配层，需按拥挤距离排序该层
		if(combinedPopulation.get(this.configuration.getPopulationSize()).getRank() == lastFrontToConsider)
			Service.sortFrontWithCrowdingDistance(combinedPopulation.getPopulace(), lastFrontToConsider);

		// 选择前 N 个个体作为下一代父代
		for(int i = 0; i < this.configuration.getPopulationSize(); i++)
			childPopulace.add(combinedPopulation.get(i));

		return new Population(childPopulace);
	}

	/**
	 * 执行快速非支配排序，将种群划分为不同非支配层级（rank），是 NSGA-II 的核心步骤。
	 * 算法流程：
	 * 1. 初始化每个染色体的支配计数（被多少个体支配）和被支配集合（支配哪些个体）
	 * 2. 支配计数为 0 的个体划为第一层（rank=1）
	 * 3. 对每一层个体，遍历其被支配集合，递减被支配个体的支配计数；若支配计数为 0，
	 *    则将该个体划入当前层 +1 的新层级
	 *
	 * @param population 待排序的种群对象，排序后染色体的 rank 字段被赋值
	 */
	public void fastNonDominatedSort(Population population) {

		List<Chromosome> populace = population.getPopulace();

		// 重置染色体的支配计数、被支配集合和 rank
		for(Chromosome chromosome : populace)
			chromosome.reset();

		// 计算每个染色体的支配关系（支配计数和被支配集合）
		for(int i = 0; i < populace.size() - 1; i++) {
			for (int j = i + 1; j < populace.size(); j++)
				switch (this.dominates(populace.get(i), populace.get(j))) {
					case NSGA2.DOMINANT:
						// 染色体 i 支配 j：i 的被支配集合添加 j，j 的支配计数 +1
						populace.get(i).addDominatedChromosome(populace.get(j));
						populace.get(j).incrementDominatedCount(1);
						break;
					case NSGA2.INFERIOR:
						// 染色体 j 支配 i：j 的被支配集合添加 i，i 的支配计数 +1
						populace.get(i).incrementDominatedCount(1);
						populace.get(j).addDominatedChromosome(populace.get(i));
						break;
					case NSGA2.NON_DOMINATED:
						// 非支配关系，不做处理
						break;
				}

			// 支配计数为 0 的个体划入第一层（rank=1）
			if(populace.get(i).getDominatedCount() == 0)
				populace.get(i).setRank(1);
		}

		// 处理最后一个个体（上述循环未覆盖 i = populace.size()-1 的情况）
		if(population.getLast().getDominatedCount() == 0)
			population.getLast().setRank(1);

		// 逐层计算剩余个体的 rank（当前层个体的被支配集合中，支配计数为 0 的个体划入下一层）
		while(Service.populaceHasUnsetRank(populace)) {
			populace.forEach(chromosome -> {
				if(chromosome.getRank() != -1) // 仅处理已确定 rank 的个体
					chromosome.getDominatedChromosomes().forEach(dominatedChromosome -> {
						if(dominatedChromosome.getDominatedCount() > 0) {
							dominatedChromosome.incrementDominatedCount(-1);
							// 若支配计数减为 0，将其 rank 设为当前个体 rank +1
							if(dominatedChromosome.getDominatedCount() == 0)
								dominatedChromosome.setRank(chromosome.getRank() + 1);
						}
					});
			});
		}
	}

	/**
	 * 为种群中的每个染色体分配拥挤距离，衡量个体在当前非支配层中的拥挤程度，
	 * 距离越大表示周围个体越少，多样性越好。算法流程：
	 * 1. 对每个目标函数，将种群按目标值排序
	 * 2. 边界个体（目标值最大/最小）赋予无限大距离
	 * 3. 中间个体的距离 = 相邻个体目标值差 / 目标值范围，累加所有目标函数的距离
	 *
	 * @param population 待计算拥挤距离的种群，需先完成非支配排序（rank 已确定）
	 */
	public void crowdingDistanceAssignment(Population population) {

		int size = population.size();

		// 对每个目标函数单独计算拥挤距离分量
		for(int i = 0; i < this.configuration.objectives.size(); i++) {

			int iFinal = i; // lambda 表达式中需使用 final 变量

			// 按第 i 个目标函数值降序排序种群
			population.getPopulace().sort(Collections.reverseOrder(Comparator.comparingDouble(c -> c.getObjectiveValue(iFinal))));
			// 归一化目标函数值（便于不同目标间距离比较）
			Service.normalizeSortedObjectiveValues(population, i);
			// 边界个体（第一个和最后一个）赋予最大拥挤距离（确保被保留）
			population.get(0).setCrowdingDistance(Double.MAX_VALUE);
			population.getLast().setCrowdingDistance(Double.MAX_VALUE);

			// 获取当前目标函数归一化后的最大/最小值（用于距离计算）
			double maxNormalizedObjectiveValue = population.selectMaximumNormalizedObjectiveValue(i);
			double minNormalizedObjectiveValue = population.selectMinimumNormalizedObjectiveValue(i);

			// 计算中间个体的拥挤距离分量
			for(int j = 1; j < size; j++)
				if(population.get(j).getCrowdingDistance() < Double.MAX_VALUE) { // 跳过边界个体
					// 相邻个体的目标值差
					double previousChromosomeObjectiveValue = population.get(j - 1).getNormalizedObjectiveValues().get(i);
					double nextChromosomeObjectiveValue = population.get(j + 1).getNormalizedObjectiveValues().get(i);
					double objectiveDifference = nextChromosomeObjectiveValue - previousChromosomeObjectiveValue;
					// 目标值范围（避免除零）
					double minMaxDifference = maxNormalizedObjectiveValue - minNormalizedObjectiveValue;

					// 累加当前目标函数的拥挤距离分量（保留4位小数）
					population.get(j).setCrowdingDistance(
							Service.roundOff(
									population.get(j).getCrowdingDistance() +
											(objectiveDifference / minMaxDifference),
									4
							)
					);
				}
		}
	}

	/**
	 * 判断两个染色体的支配关系，返回 DOMINANT/INFERIOR/NON_DOMINATED 之一。
	 * 支配关系定义参见 {@link #isDominant(Chromosome, Chromosome)}。
	 *
	 * @param chromosome1 待判定支配关系的染色体
	 * @param chromosome2 比较基准染色体
	 * @return DOMINANT（1支配2）、INFERIOR（1被2支配）或 NON_DOMINATED（非支配）
	 */
	public int dominates(Chromosome chromosome1, Chromosome chromosome2) {
		if(this.isDominant(chromosome1, chromosome2)) return NSGA2.DOMINANT;
		else if(this.isDominant(chromosome2, chromosome1)) return NSGA2.INFERIOR;
		else return NSGA2.NON_DOMINATED;
	}

	/**
	 * 判断 chromosome1 是否支配 chromosome2，支配条件：
	 * 1. chromosome1 的所有目标函数值不劣于 chromosome2
	 * 2. chromosome1 至少有一个目标函数值严格优于 chromosome2
	 * （注：目标函数默认越小越优，若需最大化目标需在配置时对目标值取负）
	 *
	 * @param chromosome1 潜在支配者
	 * @param chromosome2 潜在被支配者
	 * @return true 若 chromosome1 支配 chromosome2，否则 false
	 */
	public boolean isDominant(Chromosome chromosome1, Chromosome chromosome2) {

		boolean atLeastOneIsBetter = false;

		// 遍历所有目标函数，检查支配条件
		for(int i = 0; i < this.configuration.objectives.size(); i++) {
			double obj1 = chromosome1.getObjectiveValue(i);
			double obj2 = chromosome2.getObjectiveValue(i);

			if(obj1 > obj2) {
				// 若 chromosome1 有一个目标值劣于 chromosome2，则不支配
				return false;
			} else if(obj1 < obj2) {
				// 记录至少有一个目标值优于 chromosome2
				atLeastOneIsBetter = true;
			}
			// 目标值相等时不影响支配判定
		}

		// 所有目标不劣于，且至少一个目标更优 → 支配
		return atLeastOneIsBetter;
	}

	/**
	 * 去除染色体列表中的重复个体，基于遗传编码（genetic code）判断重复。
	 * 实现逻辑：遍历列表，仅保留与已添加个体遗传编码不同的染色体。
	 *
	 * @param chromosome 待去重的染色体列表（需非空，否则可能抛出索引异常）
	 * @return 去重后的染色体列表，保留原始顺序
	 */
	public static List<Chromosome> deleteDuplicate(List<Chromosome> chromosome){
		List<Chromosome> results = new ArrayList<>();
		results.add(chromosome.get(0)); // 添加第一个个体（默认不重复）
		int j = 0; // 已添加个体的索引指针
		// 遍历剩余个体，检查遗传编码是否与已添加个体重复
		for (int i = 1; i < chromosome.size(); i++){
			if (!chromosome.get(i).identicalGeneticCode(results.get(j))){
				results.add(chromosome.get(i));
				j++;
			}
		}
		return results;
	}
}