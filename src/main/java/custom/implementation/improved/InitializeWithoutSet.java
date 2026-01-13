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

public class InitializeWithoutSet implements PopulationProducer {

    public static final int DOMINANT = 1;
    public static final int INFERIOR = 2;
    public static final int NON_DOMINATED = 3;

    private final List<Integer> lower;
    private final List<Integer> upper;
    private final List<Integer> suppliersNum;
    private final List<Integer> demand;

    private final List<AbstractObjectiveFunction> objectives;
    private final Chromosome originalSolution;

    public InitializeWithoutSet(List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum, List<Integer> demand, List<AbstractObjectiveFunction> objectives, Chromosome originalSolution) {
        this.lower = lower;
        this.upper = upper;
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.objectives = objectives;
        this.originalSolution = originalSolution;
    }

    @Override
    public Population produce(int populationSize, int chromosomeLength, GeneticCodeProducer geneticCodeProducer, FitnessCalculator fitnessCalculator) {
        int targetFunctionSize = (int)(populationSize * 0.4);
        int localSearchSize = populationSize - targetFunctionSize * 2;
        List<Chromosome> localSearchChromosomes = this.localSearchInitialize(originalSolution, localSearchSize, populationSize);
        //2个目标函数分别生成2组初始解
        List<Chromosome> targetFunctionChromosomes1 = this.targetFunctionInitialize(objectives.get(0), targetFunctionSize, populationSize, chromosomeLength, geneticCodeProducer);
        List<Chromosome> targetFunctionChromosomes2 = this.targetFunctionInitialize(objectives.get(1), targetFunctionSize, populationSize, chromosomeLength, geneticCodeProducer);
        List<Chromosome> chromosomes = new ArrayList<>();
        for (int i = 0; i < localSearchChromosomes.size(); i++){
            chromosomes.add(i,localSearchChromosomes.get(i));
        }
        for (int j = 0; j < targetFunctionChromosomes1.size(); j++){
            chromosomes.add(j + localSearchChromosomes.size(),targetFunctionChromosomes1.get(j));
        }
        for (int k = 0; k < targetFunctionChromosomes2.size(); k++){
            chromosomes.add(k + localSearchChromosomes.size() + targetFunctionChromosomes1.size(),targetFunctionChromosomes2.get(k));
        }

        return new Population(chromosomes);
    }

    //originalSolution不一定满足要求
    public List<Chromosome> localSearchInitialize(Chromosome originalSolution, int localSearchSize, int populationSize){
        ConstraintFactor constraintFactor = new ConstraintFactor();
        List<IntegerAllele> originalChromosomeCopy = new ArrayList<>();
        //将输入的染色体中的基因存入到originalChromosomeCopy中
        for (int i = 0; i < originalSolution.getLength(); i++){
            originalChromosomeCopy.add(i,(IntegerAllele) originalSolution.getGeneticCode().get(i).getCopy());
        }

        //初始解不满足时需要修复
        if (!(constraintFactor.satisfyDemand(originalChromosomeCopy,suppliersNum,demand))){
            originalChromosomeCopy = new RepairWithoutSet().repair(originalSolution, lower, upper, suppliersNum, demand);
        }
        //局部搜索方法为：选取一段基因不变，其余随机变化并且选出规定数量的局部最优解
        //选取染色体中的一段，且不能全选
        int first = ThreadLocalRandom.current().nextInt(0, originalChromosomeCopy.size());
        int last = 0;
        int ex = 0;
        if (first == 0 || first == originalChromosomeCopy.size() -1){
            last = ThreadLocalRandom.current().nextInt(1, originalChromosomeCopy.size() - 1);
        }else {
            do {
                last = ThreadLocalRandom.current().nextInt(0,originalChromosomeCopy.size());
            }while (first == last);
        }
        if (last < first){
            ex = last;
            last = first;
            first = ex;
        }

        //生成populationSize个局部解[排除掉错误的染色体后]，排序选出规定数量个(包括初始解)
        //originalChromosomeCopy中从first到last的基因段不变，其余随机生成并且满足约束条件
        //first和last不位于边界时和位于边界时两种情况讨论
        List<Chromosome> searchSolute = new ArrayList<>();
        //初始解（或者修复后的）作为一个局部待选解
        searchSolute.add(new Chromosome(originalChromosomeCopy));
        //找寻populationSize个满足条件的染色体
        do {
            for (int i = 0; i < first; i++){
                originalChromosomeCopy.set(i,new IntegerAllele(this.orderGenerate(i, lower, upper)));
            }
            for (int i = last + 1; i < originalChromosomeCopy.size(); i++){
                originalChromosomeCopy.set(i,new IntegerAllele(this.orderGenerate(i, lower, upper)));
            }
            //如果搜索到的染色体满足约束，则
            if (constraintFactor.satisfyDemand(originalChromosomeCopy,suppliersNum,demand)){
                searchSolute.add(new Chromosome(originalChromosomeCopy));
            }
        }while (searchSolute.size() < populationSize);
        //排序，之后从sortedSearchSolute中选择规定数量个染色体至targetChromosome中
        List<Chromosome> sortedSearchSolute = this.sortPopulation(new Population(searchSolute));
        List<Chromosome> targetChromosome = new ArrayList<>();

        for (int i = 0; i < localSearchSize; i++){
            targetChromosome.add(i,sortedSearchSolute.get(i));
        }
        return targetChromosome;
    }

    public List<Chromosome> targetFunctionInitialize(AbstractObjectiveFunction function, int targetFunctionSize, int populationSize, int chromosomeLength, GeneticCodeProducer geneticCodeProducer){
        List<Chromosome> targetChromosomes = new ArrayList<>();
        for(int i = 0; i < targetFunctionSize; ++i) {
            int circulation = 0;
            List<Chromosome> cirChromosome = new ArrayList<>();
            List<Double> cirValue = new ArrayList<>();
            //随机生成一定数量染色体,并和其对应目标函数值存入两个数组中
            while (circulation < populationSize){
                //第一次保存数据
                if (circulation == 0){
                    Chromosome chromosome1 = new Chromosome(geneticCodeProducer.produce(chromosomeLength));
                    cirChromosome.add(0,chromosome1);
                    cirValue.add(0,function.getValue(chromosome1));
                }else {
                    Chromosome chromosome2 = new Chromosome(geneticCodeProducer.produce(chromosomeLength));
                    if (function.getValue(chromosome2) < cirValue.get(0)){
                        cirChromosome.set(0,chromosome2);
                        cirValue.set(0,function.getValue(chromosome2));
                    }
                }
                circulation++;
            }
            targetChromosomes.add(i,cirChromosome.get(0));
        }
        return targetChromosomes;
    }

    //随机生成供应商订单量[min,max]及0（表示不选择供应商）
    public int orderGenerate(int i, List<Integer> lower, List<Integer> upper){
        if (lower.get(i) == 0){
            return ThreadLocalRandom.current().nextInt(0,upper.get(i) + 1);
        }else {
            //例：将订单范围0，[3,6]变为[0，4]
            int orderNumber = ThreadLocalRandom.current().nextInt(0,upper.get(i) - lower.get(i) + 2);
            if (orderNumber == 0){
                return 0;
            }else {
                return orderNumber + lower.get(i) - 1;
            }
        }
    }


    //将局部解集按照拥挤度排序，参考NSGA2中preparePopulation方法
    public List<Chromosome> sortPopulation(Population population) {
        Service.calculateObjectiveValues(population, this.objectives);
        this.fastNonDominatedSort(population);
        this.crowdingDistanceAssignment(population);
        population.getPopulace().sort(Comparator.comparingInt(Chromosome::getRank));

        return population.getPopulace();
    }
    //
    public void fastNonDominatedSort(Population population) {

        List<Chromosome> populace = population.getPopulace();

        for(Chromosome chromosome : populace)
            chromosome.reset();

        for(int i = 0; i < populace.size() - 1; i++) {
            for (int j = i + 1; j < populace.size(); j++)
                switch (this.dominates(populace.get(i), populace.get(j))) {

                    case InitializeWithoutSet.DOMINANT:

                        populace.get(i).addDominatedChromosome(populace.get(j));
                        populace.get(j).incrementDominatedCount(1);
                        break;

                    case InitializeWithoutSet.INFERIOR:

                        populace.get(i).incrementDominatedCount(1);
                        populace.get(j).addDominatedChromosome(populace.get(i));
                        break;

                    case InitializeWithoutSet.NON_DOMINATED:
                        break;
                }

            if(populace.get(i).getDominatedCount() == 0)
                populace.get(i).setRank(1);
        }

        if(population.getLast().getDominatedCount() == 0)
            population.getLast().setRank(1);

        while(Service.populaceHasUnsetRank(populace)) {
            populace.forEach(chromosome -> {
                if(chromosome.getRank() != -1)
                    chromosome.getDominatedChromosomes().forEach(dominatedChromosome -> {
                        if(dominatedChromosome.getDominatedCount() > 0) {

                            dominatedChromosome.incrementDominatedCount(-1);

                            if(dominatedChromosome.getDominatedCount() == 0)
                                dominatedChromosome.setRank(chromosome.getRank() + 1);
                        }
                    });
            });
        }
    }
    //
    public void crowdingDistanceAssignment(Population population) {

        int size = population.size();

        for(int i = 0; i < this.objectives.size(); i++) {

            int iFinal = i;

            population.getPopulace().sort(Collections.reverseOrder(Comparator.comparingDouble(c -> c.getObjectiveValue(iFinal))));
            Service.normalizeSortedObjectiveValues(population, i);
            population.get(0).setCrowdingDistance(Double.MAX_VALUE);
            population.getLast().setCrowdingDistance(Double.MAX_VALUE);

            double maxNormalizedObjectiveValue = population.selectMaximumNormalizedObjectiveValue(i);
            double minNormalizedObjectiveValue = population.selectMinimumNormalizedObjectiveValue(i);

            for(int j = 1; j < size; j++)
                if(population.get(j).getCrowdingDistance() < Double.MAX_VALUE) {

                    double previousChromosomeObjectiveValue = population.get(j - 1).getNormalizedObjectiveValues().get(i);
                    double nextChromosomeObjectiveValue = population.get(j + 1).getNormalizedObjectiveValues().get(i);
                    double objectiveDifference = nextChromosomeObjectiveValue - previousChromosomeObjectiveValue;
                    double minMaxDifference = maxNormalizedObjectiveValue - minNormalizedObjectiveValue;

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
    //
    public int dominates(Chromosome chromosome1, Chromosome chromosome2) {

        if(this.isDominant(chromosome1, chromosome2)) return InitializePop.DOMINANT;
        else if(this.isDominant(chromosome2, chromosome1)) return InitializePop.INFERIOR;
        else return InitializePop.NON_DOMINATED;
    }
    //
    public boolean isDominant(Chromosome chromosome1, Chromosome chromosome2) {

        boolean atLeastOneIsBetter = false;

        for(int i = 0; i < this.objectives.size(); i++)
            if(chromosome1.getObjectiveValues().get(i) > chromosome2.getObjectiveValues().get(i))
                return false;
            else if(chromosome1.getObjectiveValues().get(i) < chromosome2.getObjectiveValues().get(i))
                atLeastOneIsBetter = true;

        return atLeastOneIsBetter;
    }

}
