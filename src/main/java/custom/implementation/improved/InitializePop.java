package custom.implementation.improved;

import com.debacharya.nsgaii.Service;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.datastructure.Population;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;
import com.debacharya.nsgaii.plugin.FitnessCalculator;
import com.debacharya.nsgaii.plugin.GeneticCodeProducer;
import com.debacharya.nsgaii.plugin.PopulationProducer;
import custom.implementation.constraint.ConstraintFactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InitializePop implements PopulationProducer {

    public static final int DOMINANT = 1;
    public static final int INFERIOR = 2;
    public static final int NON_DOMINATED = 3;

    private final List<Integer> lower;
    private final List<Integer> upper;
    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Double> dq;
    private final List<Double> de;
    private final int cr;
    private final double deliveryDate;
    private final List<Double> tp;
    private final List<Double> transportDate;

    private final List<AbstractObjectiveFunction> objectives;
    private final Chromosome originalSolution;

    // 构造函数补充空指针校验
    public InitializePop(List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum, List<Integer> demand,
                         List<Double> dq, List<Double> de, int cr, double deliveryDate, List<Double> tp,
                         List<Double> transportDate, List<AbstractObjectiveFunction> objectives, Chromosome originalSolution) {
        // 空指针快速失败校验
        if (lower == null || upper == null || suppliersNum == null || demand == null || dq == null || de == null
                || tp == null || transportDate == null || objectives == null || originalSolution == null) {
            throw new IllegalArgumentException("所有入参不可为null");
        }
        if (objectives.size() < 2) {
            throw new IllegalArgumentException("目标函数列表至少包含2个目标函数");
        }

        this.lower = lower;
        this.upper = upper;
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.dq = dq;
        this.de = de;
        this.cr = cr;
        this.deliveryDate = deliveryDate;
        this.tp = tp;
        this.transportDate = transportDate;
        this.objectives = objectives;
        this.originalSolution = originalSolution;
    }

    @Override
    public Population produce(int populationSize, int chromosomeLength, GeneticCodeProducer geneticCodeProducer, FitnessCalculator fitnessCalculator) {
        // 边界校验：种群规模需大于0，染色体长度需大于0
        if (populationSize <= 0 || chromosomeLength <= 0) {
            throw new IllegalArgumentException("种群规模和染色体长度必须大于0");
        }

        int targetFunctionSize = (int) (populationSize * 0.4);
        // 确保局部搜索规模非负
        int localSearchSize = Math.max(0, populationSize - targetFunctionSize * 2);

        List<Chromosome> localSearchChromosomes = this.localSearchInitialize(originalSolution, localSearchSize, populationSize);
        List<Chromosome> targetFunctionChromosomes1 = this.targetFunctionInitialize(objectives.get(0), targetFunctionSize, populationSize, chromosomeLength, geneticCodeProducer);
        List<Chromosome> targetFunctionChromosomes2 = this.targetFunctionInitialize(objectives.get(1), targetFunctionSize, populationSize, chromosomeLength, geneticCodeProducer);

        List<Chromosome> chromosomes = new ArrayList<>();
        chromosomes.addAll(localSearchChromosomes);
        chromosomes.addAll(targetFunctionChromosomes1);
        chromosomes.addAll(targetFunctionChromosomes2);

        // 初始化种群后去重并补充至指定规模
        chromosomes = ChromosomeDuplicateRemover.removeDuplicatesAndSupplement(chromosomes, populationSize);

        return new Population(chromosomes);
    }

    // 局部搜索初始化：基于原始解生成局部最优解
    public List<Chromosome> localSearchInitialize(Chromosome originalSolution, int localSearchSize, int populationSize) {
        // 边界校验
        if (localSearchSize <= 0) {
            return new ArrayList<>();
        }
        if (populationSize <= localSearchSize) {
            throw new IllegalArgumentException("种群规模必须大于局部搜索规模");
        }

        ConstraintFactor constraintFactor = new ConstraintFactor();
        // 深拷贝原始解，避免修改原始对象
        List<IntegerAllele> originalGenes = new ArrayList<>();
        for (int i = 0; i < originalSolution.getLength(); i++) {
            IntegerAllele allele = (IntegerAllele) originalSolution.getGeneticCode().get(i).getCopy();
            originalGenes.add(allele);
        }

        List<Integer> upperOrder = constraintFactor.getUpperOrder(deliveryDate, tp, transportDate, upper);
        List<Boolean> suppliersChoose = constraintFactor.suppliersChoose(deliveryDate, tp, transportDate, lower);

        // 修复原始解（若不满足约束）
        if (!constraintFactor.satisfyDemand(originalGenes, suppliersNum, demand)
                || !constraintFactor.satisfyOrderFulfillment(originalGenes, suppliersNum, demand, dq, de, cr)) {
            originalGenes = new RepairMechanism().repair1(new Chromosome(originalGenes),
                    lower, upperOrder, suppliersNum, demand, dq, de, cr, deliveryDate, tp, transportDate);
        }

        // 随机选取不变的基因段（first ~ last）
        int geneLength = originalGenes.size();
        int first = ThreadLocalRandom.current().nextInt(0, geneLength);
        int last = ThreadLocalRandom.current().nextInt(0, geneLength);
        // 确保first < last且不重合
        if (first > last) {
            int temp = first;
            first = last;
            last = temp;
        }
        if (first == last) {
            last = (last + 1) % geneLength;
            if (first > last) {
                int temp = first;
                first = last;
                last = temp;
            }
        }

        // 生成局部搜索解
        List<Chromosome> searchSolutions = new ArrayList<>();
        // 添加修复后的原始解作为初始候选
        searchSolutions.add(new Chromosome(new ArrayList<>(originalGenes)));

        // 生成足够的候选解（去重前）
        while (searchSolutions.size() < populationSize) {
            // 每次基于原始解拷贝生成新解，避免覆盖
            List<IntegerAllele> newGenes = new ArrayList<>(originalGenes);

            // 修改first之前的基因
            for (int i = 0; i < first; i++) {
                if (suppliersChoose.get(i)) {
                    newGenes.set(i, new IntegerAllele(this.orderGenerate(i, lower, upperOrder)));
                } else {
                    newGenes.set(i, new IntegerAllele(0));
                }
            }
            // 修改last之后的基因
            for (int i = last + 1; i < geneLength; i++) {
                if (suppliersChoose.get(i)) {
                    newGenes.set(i, new IntegerAllele(this.orderGenerate(i, lower, upperOrder)));
                } else {
                    newGenes.set(i, new IntegerAllele(0));
                }
            }

            // 校验约束并添加有效解
            if (constraintFactor.satisfyDemand(newGenes, suppliersNum, demand)
                    && constraintFactor.satisfyOrderFulfillment(newGenes, suppliersNum, demand, dq, de, cr)) {
                searchSolutions.add(new Chromosome(newGenes));
            }
        }

        // 去重
        searchSolutions = ChromosomeDuplicateRemover.removeDuplicates(searchSolutions);
        // 排序（NSGA2）
        List<Chromosome> sortedSolutions = this.sortPopulation(new Population(searchSolutions));
        // 选取指定数量的局部最优解
        List<Chromosome> targetChromosomes = new ArrayList<>();
        int takeSize = Math.min(localSearchSize, sortedSolutions.size());
        for (int i = 0; i < takeSize; i++) {
            targetChromosomes.add(sortedSolutions.get(i));
        }

        // 去重并补充至指定规模
        targetChromosomes = ChromosomeDuplicateRemover.removeDuplicatesAndSupplement(targetChromosomes, localSearchSize);

        return targetChromosomes;
    }

    // 基于目标函数生成初始解（单目标最优）
    public List<Chromosome> targetFunctionInitialize(AbstractObjectiveFunction function, int targetFunctionSize,
                                                     int populationSize, int chromosomeLength, GeneticCodeProducer geneticCodeProducer) {
        // 边界校验
        if (targetFunctionSize <= 0 || populationSize <= 0 || chromosomeLength <= 0) {
            return new ArrayList<>();
        }

        List<Chromosome> targetChromosomes = new ArrayList<>();
        // 为每个目标函数生成指定数量的最优解
        for (int i = 0; i < targetFunctionSize; i++) {
            Chromosome bestChromosome = null;
            double bestValue = Double.MAX_VALUE;

            // 随机生成种群并筛选最优
            for (int j = 0; j < populationSize; j++) {
                Chromosome chromosome = new Chromosome(geneticCodeProducer.produce(chromosomeLength));
                double currentValue = function.getValue(chromosome);

                // 更新最优解
                if (currentValue < bestValue) {
                    bestValue = currentValue;
                    bestChromosome = chromosome;
                }
            }

            // 确保最优解非空
            if (bestChromosome != null) {
                targetChromosomes.add(bestChromosome);
            }
        }

        // 去重并补充至指定规模
        targetChromosomes = ChromosomeDuplicateRemover.removeDuplicatesAndSupplement(targetChromosomes, targetFunctionSize);

        return targetChromosomes;
    }

    // 随机生成供应商订单量[min,max]及0（表示不选择供应商）
    public int orderGenerate(int i, List<Integer> lower, List<Integer> upper) {
        // 边界校验
        if (i < 0 || i >= lower.size() || i >= upper.size()) {
            return 0;
        }

        if (lower.get(i) == 0) {
            return ThreadLocalRandom.current().nextInt(0, upper.get(i) + 1);
        } else {
            // 例：将订单范围0，[3,6]变为[0，4]
            int range = upper.get(i) - lower.get(i) + 2;
            int orderNumber = ThreadLocalRandom.current().nextInt(0, range);
            if (orderNumber != 0) {
                int result = orderNumber + lower.get(i) - 1;
                if (result >= lower.get(i)) {
                    return result;
                }
            }
            return 0;
        }
    }

    // NSGA2排序：非支配排序 + 拥挤度计算
    public List<Chromosome> sortPopulation(Population population) {
        Service.calculateObjectiveValues(population, this.objectives);
        this.fastNonDominatedSort(population);
        this.crowdingDistanceAssignment(population);
        // 先按排名排序，再按拥挤度降序排序
        population.getPopulace().sort(Comparator.comparingInt(Chromosome::getRank)
                .thenComparing(Comparator.comparingDouble(Chromosome::getCrowdingDistance).reversed()));

        return population.getPopulace();
    }

    // 快速非支配排序
    public void fastNonDominatedSort(Population population) {
        List<Chromosome> populace = population.getPopulace();

        // 重置染色体的支配信息
        for (Chromosome chromosome : populace) {
            chromosome.reset();
        }

        // 计算支配关系
        for (int i = 0; i < populace.size(); i++) {
            Chromosome chrI = populace.get(i);
            for (int j = 0; j < populace.size(); j++) {
                if (i == j) {
                    continue;
                }
                Chromosome chrJ = populace.get(j);
                switch (this.dominates(chrI, chrJ)) {
                    case DOMINANT:
                        chrI.addDominatedChromosome(chrJ);
                        chrJ.incrementDominatedCount(1);
                        break;
                    case INFERIOR:
                        chrI.incrementDominatedCount(1);
                        chrJ.addDominatedChromosome(chrI);
                        break;
                    case NON_DOMINATED:
                        break;
                }
            }
            // 初始排名（支配数为0的为第一级）
            if (chrI.getDominatedCount() == 0) {
                chrI.setRank(1);
            }
        }

        // 迭代计算所有层级的排名
        while (Service.populaceHasUnsetRank(populace)) {
            populace.forEach(chromosome -> {
                if (chromosome.getRank() != -1) {
                    chromosome.getDominatedChromosomes().forEach(dominatedChromosome -> {
                        if (dominatedChromosome.getDominatedCount() > 0) {
                            dominatedChromosome.incrementDominatedCount(-1);
                            if (dominatedChromosome.getDominatedCount() == 0) {
                                dominatedChromosome.setRank(chromosome.getRank() + 1);
                            }
                        }
                    });
                }
            });
        }
    }

    // 拥挤度计算
    public void crowdingDistanceAssignment(Population population) {
        int size = population.size();
        if (size == 0) {
            return;
        }

        for (int i = 0; i < this.objectives.size(); i++) {
            int objectiveIndex = i;
            // 按目标函数值降序排序
            population.getPopulace().sort(Collections.reverseOrder(
                    Comparator.comparingDouble(c -> c.getObjectiveValue(objectiveIndex))));

            // 归一化目标函数值
            Service.normalizeSortedObjectiveValues(population, objectiveIndex);

            // 边界个体拥挤度设为最大值
            population.get(0).setCrowdingDistance(Double.MAX_VALUE);
            if (size > 1) {
                population.get(size - 1).setCrowdingDistance(Double.MAX_VALUE);
            }

            double maxNormValue = population.selectMaximumNormalizedObjectiveValue(objectiveIndex);
            double minNormValue = population.selectMinimumNormalizedObjectiveValue(objectiveIndex);
            double minMaxDiff = maxNormValue - minNormValue;

            // 计算中间个体的拥挤度
            for (int j = 1; j < size - 1; j++) {
                Chromosome current = population.get(j);
                if (current.getCrowdingDistance() < Double.MAX_VALUE && minMaxDiff != 0) {
                    double prevValue = population.get(j - 1).getNormalizedObjectiveValues().get(objectiveIndex);
                    double nextValue = population.get(j + 1).getNormalizedObjectiveValues().get(objectiveIndex);
                    double diff = nextValue - prevValue;
                    current.setCrowdingDistance(Service.roundOff(
                            current.getCrowdingDistance() + (diff / minMaxDiff), 4));
                }
            }
        }
    }

    // 判断支配关系
    public int dominates(Chromosome chromosome1, Chromosome chromosome2) {
        if (this.isDominant(chromosome1, chromosome2)) {
            return DOMINANT;
        } else if (this.isDominant(chromosome2, chromosome1)) {
            return INFERIOR;
        } else {
            return NON_DOMINATED;
        }
    }

    // 判断chromosome1是否支配chromosome2
    public boolean isDominant(Chromosome chromosome1, Chromosome chromosome2) {
        boolean atLeastOneBetter = false;
        for (int i = 0; i < this.objectives.size(); i++) {
            double val1 = chromosome1.getObjectiveValues().get(i);
            double val2 = chromosome2.getObjectiveValues().get(i);
            // 若有一个目标更差，则不支配
            if (val1 > val2) {
                return false;
            }
            // 若有一个目标更好，则标记
            else if (val1 < val2) {
                atLeastOneBetter = true;
            }
        }
        return atLeastOneBetter;
    }
}