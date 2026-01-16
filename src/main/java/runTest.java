import com.debacharya.nsgaii.Configuration;
import com.debacharya.nsgaii.NSGA2;
import com.debacharya.nsgaii.Service;
import com.debacharya.nsgaii.crossover.CrossoverParticipantCreatorProvider;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.datastructure.Population;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import custom.implementation.Crossover.CrossoverWithSet;
import custom.implementation.Crossover.CrossoverWithoutSet;
import custom.implementation.Crossover.IntegerCodeUniformCrossover;
import custom.implementation.GeneticCode.CodeProducerWithoutSet;
import custom.implementation.GeneticCode.OrderAllocationGeneticCodeProducer;
import custom.implementation.comparison.PerformancePlot;
import custom.implementation.improved.InitializePop;
import custom.implementation.improved.InitializeWithoutSet;
import custom.implementation.mutation.IntegerSinglePointMutation;
import custom.implementation.mutation.MutationWithSet;
import custom.implementation.mutation.MutationWithoutSet;
import custom.implementation.targetFunctions.*;
import org.jfree.data.xy.XYSeries;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class runTest {


    public static void main(String[] args) {

        List<AbstractObjectiveFunction> objectives = new ArrayList<>();


        List<Integer> lower = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        List<Integer> suppliersNum = new ArrayList<>();
        List<Integer> demand = new ArrayList<>();
        List<Double> dq = new ArrayList<>();
        List<Double> de = new ArrayList<>();
        int cr = 100;
        double deliveryDate = 12.0;
        List<Double> tp = new ArrayList<>();
        List<Double> transportDate = new ArrayList<>();

        lower.add(100);
        lower.add(0);
        lower.add(300);
        lower.add(100);
        lower.add(0);
        lower.add(50);
        lower.add(60);
        lower.add(30);
        lower.add(30);
        lower.add(20);

        upper.add(600);
        upper.add(1000);
        upper.add(1000);
        upper.add(1200);
        upper.add(1500);
        upper.add(1400);
        upper.add(1000);
        upper.add(500);
        upper.add(600);
        upper.add(600);

        suppliersNum.add(2);
        suppliersNum.add(5);
        suppliersNum.add(3);

        demand.add(900);
        demand.add(3600);
        demand.add(900);

        dq.add(0.03);
        dq.add(0.05);
        dq.add(0.025);
        dq.add(0.04);
        dq.add(0.03);
        dq.add(0.05);
        dq.add(0.02);
        dq.add(0.035);
        dq.add(0.05);
        dq.add(0.04);

        de.add(0.02);
        de.add(0.03);
        de.add(0.025);
        de.add(0.015);
        de.add(0.03);
        de.add(0.03);
        de.add(0.025);
        de.add(0.025);
        de.add(0.03);
        de.add(0.03);

        tp.add(0.01667);
        tp.add(1/85.0);
        tp.add(1/90.0);
        tp.add(1/125.0);
        tp.add(1/134.0);
        tp.add(1/132.0);
        tp.add(1/102.0);
        tp.add(1/48.0);
        tp.add(1/50.0);
        tp.add(1/58.0);

        transportDate.add(0.5);
        transportDate.add(1.0);
        transportDate.add(1.0);
        transportDate.add(1.5);
        transportDate.add(1.0);
        transportDate.add(2.0);
        transportDate.add(1.0);
        transportDate.add(0.5);
        transportDate.add(0.5);
        transportDate.add(0.25);

        objectives.add(new TotalCost(suppliersNum,demand,dq,de));
        objectives.add(new unqualifiedQuantity(dq,de));

        int length = suppliersNum.get(0) + suppliersNum.get(1) + suppliersNum.get(2);


        //初始解
        List<IntegerAllele> original = new ArrayList<>();
//        original.add(new IntegerAllele(162));
//        original.add(new IntegerAllele(740));
//        original.add(new IntegerAllele(827));
//        original.add(new IntegerAllele(1018));
//        original.add(new IntegerAllele(590));
//        original.add(new IntegerAllele(169));
//        original.add(new IntegerAllele(996));
//        original.add(new IntegerAllele(484));
//        original.add(new IntegerAllele(123));
//        original.add(new IntegerAllele(293));

        original.add(new IntegerAllele(492));
        original.add(new IntegerAllele(408));
        original.add(new IntegerAllele(990));
        original.add(new IntegerAllele(1200));
        original.add(new IntegerAllele(354));
        original.add(new IntegerAllele(56));
        original.add(new IntegerAllele(996));
        original.add(new IntegerAllele(33));
        original.add(new IntegerAllele(267));
        original.add(new IntegerAllele(590));



        //{原生NSGA-II-----------------------------------------------
        IntegerSinglePointMutation mutation = new IntegerSinglePointMutation(0.1f,suppliersNum,demand,lower,upper,dq,de,cr,deliveryDate,tp,transportDate);
        IntegerCodeUniformCrossover crossover =new IntegerCodeUniformCrossover(CrossoverParticipantCreatorProvider.selectByBinaryTournamentSelection(),0.9f,suppliersNum,demand,dq,de,cr);
        Configuration configuration = new Configuration(objectives);
        //configuration.setGeneticCodeProducer(CodeProducerWithoutSet.originalGeneCodeProducer(suppliersNum,demand,lower,upper));
        configuration.setGeneticCodeProducer(OrderAllocationGeneticCodeProducer.orderAllocationGeneProducer(suppliersNum,demand,lower,upper,dq,de,cr,deliveryDate,tp,transportDate));
        configuration.setMutation(mutation);
        configuration.setCrossover(crossover);
        configuration.setGenerations(150);
        configuration.setChromosomeLength(length);
        configuration.setPopulationSize(250);

//        NSGA2 nsga21 = new NSGA2(configuration);
//        Population populationNSGA21 = nsga21.run();
//        configuration.setGenerations(60);
//        NSGA2 nsga22 = new NSGA2(configuration);
//        Population populationNSGA22 = nsga22.run();
//        configuration.setGenerations(70);
//        NSGA2 nsga23 = new NSGA2(configuration);
//        Population populationNSGA23 = nsga23.run();
//        configuration.setGenerations(80);
//        NSGA2 nsga24 = new NSGA2(configuration);
//        Population populationNSGA24 = nsga24.run();
//        configuration.setGenerations(90);
//        NSGA2 nsga25 = new NSGA2(configuration);
//        Population populationNSGA25 = nsga25.run();
        //}------------------------------------------------------------

        //{NSGA-II_RM--------------------------------------------------
        Configuration configuration1 = new Configuration(objectives);
        //configuration1.setGeneticCodeProducer(CodeProducerWithoutSet.originalGeneCodeProducer(suppliersNum,demand,lower,upper));
        configuration1.setGeneticCodeProducer(OrderAllocationGeneticCodeProducer.orderAllocationGeneProducer(suppliersNum,demand,lower,upper,dq,de,cr,deliveryDate,tp,transportDate));
        MutationWithSet mutationWithSet = new MutationWithSet(0.3f,lower,upper,suppliersNum,demand,dq,de,cr,deliveryDate,tp,transportDate);
        CrossoverWithSet crossoverWithSet = new CrossoverWithSet(CrossoverParticipantCreatorProvider.selectByBinaryTournamentSelection(),0.9f,lower,upper,suppliersNum,demand,dq,de,cr,deliveryDate,tp,transportDate);
        configuration1.setCrossover(crossoverWithSet);
        configuration1.setMutation(mutationWithSet);
//        configuration1.setPopulationProducer(new InitializeWithoutSet(lower,upper,suppliersNum,demand,objectives,new Chromosome(original)));
        configuration1.setPopulationProducer(new InitializePop(lower,upper,suppliersNum,demand,dq,de,cr,deliveryDate,tp,transportDate,objectives,new Chromosome(original)));
        configuration1.setGenerations(50);
        configuration1.setChromosomeLength(length);
        configuration1.setPopulationSize(150);
//
        NSGA2 insga21 = new NSGA2(configuration1);
        Population populationINSGA21 = insga21.run();
//        System.out.println(new TotalCost(suppliersNum, demand, dq, de).getValue(new Chromosome(original)));
//        System.out.println(new unqualifiedQuantity(dq, de).getValue(new Chromosome(original)));
//        System.out.println("*****************************************");
//        System.out.println(populationINSGA21.toString());
//        configuration1.setGenerations(60);
//        NSGA2 insga22 = new NSGA2(configuration1);
//        Population populationINSGA22 = insga22.run();
//        configuration1.setGenerations(70);
//        NSGA2 insga23 = new NSGA2(configuration1);
//        Population populationINSGA23 = insga23.run();
//        configuration1.setGenerations(80);
//        NSGA2 insga24 = new NSGA2(configuration1);
//        Population populationINSGA24 = insga24.run();
//        configuration1.setGenerations(90);
//        NSGA2 insga25 = new NSGA2(configuration1);
//        Population populationINSGA25 = insga25.run();
        //}------------------------------------------------------

//        //最后只输出rank==1的非支配解
//        List<Chromosome> populaceNSGA2 = populationNSGA2.getPopulace();
//        List<Chromosome> rankNSGA2 = new ArrayList<>();
//        boolean rank1 = true;
//        while (rank1){
//            for (Chromosome chromosome : populaceNSGA2) {
//                if (chromosome.getRank() == 1) {
//                    rankNSGA2.add(chromosome);
//                } else {
//                    break;
//                }
//            }
//            rank1 = false;
//        }
//
//        //最后只输出rank==1的非支配解
//        List<Chromosome> populaceINSGA2 = populationINSGA2.getPopulace();
//        List<Chromosome> rankINSGA2 = new ArrayList<>();
//        boolean rank2 = true;
//        while (rank2){
//            for (Chromosome chromosome : populaceINSGA2) {
//                if (chromosome.getRank() == 1) {
//                    rankINSGA2.add(chromosome);
//                } else {
//                    break;
//                }
//            }
//            rank2 = false;
//        }
//
//        List<Chromosome> NSGA2Chromosome = deleteDuplicate(rankNSGA2);
//        List<Chromosome> INSGA2Chromosome = deleteDuplicate(rankINSGA2);
//        //记录下最大、最小极端解的染色体
//        List<Chromosome> borderChromosome = new ArrayList<>();
//        if (NSGA2Chromosome.get(0).getObjectiveValue(0) <= INSGA2Chromosome.get(0).getObjectiveValue(0)){
//            borderChromosome.add(NSGA2Chromosome.get(0));
//        }else {
//            borderChromosome.add(INSGA2Chromosome.get(0));
//        }
//        if (NSGA2Chromosome.get(NSGA2Chromosome.size() - 1).getObjectiveValue(0) >= INSGA2Chromosome.get(INSGA2Chromosome.size() - 1).getObjectiveValue(0)){
//            borderChromosome.add(NSGA2Chromosome.get(NSGA2Chromosome.size() - 1));
//        }else {
//            borderChromosome.add(INSGA2Chromosome.get(INSGA2Chromosome.size() - 1));
//        }
//        List<Chromosome> dfNSGA2 = new ArrayList<>();
//        List<Chromosome> dlNSGA2 = new ArrayList<>();
//        dfNSGA2.add(borderChromosome.get(0));
//        dfNSGA2.add(NSGA2Chromosome.get(0));
//        dlNSGA2.add(borderChromosome.get(1));
//        dlNSGA2.add(NSGA2Chromosome.get(NSGA2Chromosome.size() - 1));
//        double NSGA2DM = calculateDM(dfNSGA2, dlNSGA2, NSGA2Chromosome);
//
//        List<Chromosome> dfINSGA2 = new ArrayList<>();
//        List<Chromosome> dlINSGA2 = new ArrayList<>();
//        dfINSGA2.add(borderChromosome.get(0));
//        dfINSGA2.add(INSGA2Chromosome.get(0));
//        dlINSGA2.add(borderChromosome.get(1));
//        dlINSGA2.add(INSGA2Chromosome.get(INSGA2Chromosome.size() - 1));
//        double INSGA2DM = calculateDM(dfINSGA2, dlINSGA2, INSGA2Chromosome);
//
//        List<Double> r = new ArrayList<>();
//        r.add(borderChromosome.get(1).getObjectiveValue(0) * 1.1);
//        r.add(borderChromosome.get(0).getObjectiveValue(1) * 1.1);
//        double NSGA2HV = calculateHV(NSGA2Chromosome, r);
//        double INSGA2HV = calculateHV(INSGA2Chromosome, r);
//
//        List<Double> doubles = calculateCM(NSGA2Chromosome, INSGA2Chromosome, objectives);

        //算法性能对比部分-----------------------------------------------------------------
//        List<Chromosome> PF1 = getListChromosomeWithoutDuplicate(populationNSGA21);
//        List<Chromosome> IPF1 = getListChromosomeWithoutDuplicate(populationINSGA21);
//        List<Chromosome> PF2 = getListChromosomeWithoutDuplicate(populationNSGA22);
//        List<Chromosome> IPF2 = getListChromosomeWithoutDuplicate(populationINSGA22);
//        List<Chromosome> PF3 = getListChromosomeWithoutDuplicate(populationNSGA23);
//        List<Chromosome> IPF3 = getListChromosomeWithoutDuplicate(populationINSGA23);
//        List<Chromosome> PF4 = getListChromosomeWithoutDuplicate(populationNSGA24);
//        List<Chromosome> IPF4 = getListChromosomeWithoutDuplicate(populationINSGA24);
//        List<Chromosome> PF5 = getListChromosomeWithoutDuplicate(populationNSGA25);
//        List<Chromosome> IPF5 = getListChromosomeWithoutDuplicate(populationINSGA25);

//        List<Chromosome> borderChromosome1 = getBorderChromosome(populationNSGA21,populationINSGA21);
//        List<Chromosome> borderChromosome2 = getBorderChromosome(populationNSGA22,populationINSGA22);
//        List<Chromosome> borderChromosome3 = getBorderChromosome(populationNSGA23,populationINSGA23);
//        List<Chromosome> borderChromosome4 = getBorderChromosome(populationNSGA24,populationINSGA24);
//        List<Chromosome> borderChromosome5 = getBorderChromosome(populationNSGA25,populationINSGA25);

//        List<Double> cMs1 = getCMs(PF1, IPF1, objectives);
//        List<Double> cMs2 = getCMs(PF2, IPF2, objectives);
//        List<Double> cMs3 = getCMs(PF3, IPF3, objectives);
//        List<Double> cMs4 = getCMs(PF4, IPF4, objectives);
//        List<Double> cMs5 = getCMs(PF5, IPF5, objectives);
//        System.out.println(cMs1);
//        System.out.println(cMs2);
//        System.out.println(cMs3);
//        XYSeries series1 = new XYSeries("NSGA-II");
//        XYSeries series2 = new XYSeries("NSGA-II_RM");
//        series1.add(1,cMs1.get(0));
//        series2.add(1,cMs1.get(1));
//        series1.add(2,cMs2.get(0));
//        series2.add(2,cMs2.get(1));
//        series1.add(3,cMs3.get(0));
//        series2.add(3,cMs3.get(1));
//        series1.add(4,cMs4.get(0));
//        series2.add(4,cMs4.get(1));
//        series1.add(5,cMs5.get(0));
//        series2.add(5,cMs5.get(1));
//        new PerformancePlot(series1,series2,"Comparison of CM values","number","CM values");
//
//        List<Double> hVs1 = getHVs(PF1, IPF1, borderChromosome1);
//        List<Double> hVs2 = getHVs(PF2, IPF2, borderChromosome2);
//        List<Double> hVs3 = getHVs(PF3, IPF3, borderChromosome3);
//        List<Double> hVs4 = getHVs(PF4, IPF4, borderChromosome4);
//        List<Double> hVs5 = getHVs(PF5, IPF5, borderChromosome5);
//        System.out.println(hVs1);
//        System.out.println(hVs2);
//        System.out.println(hVs3);
//        XYSeries series5 = new XYSeries("NSGA-II");
//        XYSeries series6 = new XYSeries("NSGA-II_RM");
//        series5.add(1,hVs1.get(0));
//        series6.add(1,hVs1.get(1));
//        series5.add(2,hVs2.get(0));
//        series6.add(2,hVs2.get(1));
//        series5.add(3,hVs3.get(0));
//        series6.add(3,hVs3.get(1));
//        series5.add(4,hVs4.get(0));
//        series6.add(4,hVs4.get(1));
//        series5.add(5,hVs5.get(0));
//        series6.add(5,hVs5.get(1));
//        new PerformancePlot(series5,series6,"Comparison of HV values","number","HV values");
//
//        List<Double> dMs1 = getDMs(PF1, IPF1, borderChromosome1);
//        List<Double> dMs2 = getDMs(PF2, IPF2, borderChromosome2);
//        List<Double> dMs3 = getDMs(PF3, IPF3, borderChromosome3);
//        List<Double> dMs4 = getDMs(PF4, IPF4, borderChromosome4);
//        List<Double> dMs5 = getDMs(PF5, IPF5, borderChromosome5);
//        System.out.println(dMs1);
//        System.out.println(dMs2);
//        System.out.println(dMs3);
//        XYSeries series3 = new XYSeries("NSGA-II");
//        XYSeries series4 = new XYSeries("NSGA-II_RM");
//        series3.add(1,dMs1.get(0));
//        series4.add(1,dMs1.get(1));
//        series3.add(2,dMs2.get(0));
//        series4.add(2,dMs2.get(1));
//        series3.add(3,dMs3.get(0));
//        series4.add(3,dMs3.get(1));
//        series3.add(4,dMs4.get(0));
//        series4.add(4,dMs4.get(1));
//        series3.add(5,dMs5.get(0));
//        series4.add(5,dMs5.get(1));
//        new PerformancePlot(series3,series4,"Comparison of DM values","number","DM values");
        //---------------------------------------------------------------------------------

//        new PerformancePlot(series1,series2);
//        System.out.println(run.getPopulace().get(0).getObjectiveValue(0));
//        System.out.println(run);

//        List<Integer> integers = new ArrayList<>();
//        System.out.println(integers.size());
//        System.out.println("...........");
//
//        for(int i = 0; i < 2; ++i){
//            List<Integer> t1 = new ArrayList<>();
//            int g = 0;
//            while (g < 10){
//                if (g == 0){
//                    int val = ThreadLocalRandom.current().nextInt(1,10);
//                    t1.add(0,val);
//                    System.out.println(val);
//                }else {
//                    int val2 = ThreadLocalRandom.current().nextInt(1,10);
//                    System.out.println(val2);
//                    if (val2 < t1.get(0)){
//                        t1.set(0,val2);
//                    }
//                }
//
//                g++;
//            }
//            System.out.println("--if--");
//            integers.add(i,t1.get(0));
//
//        }
//        System.out.println("------------------");
//        System.out.println(integers.get(0));
//        System.out.println(integers.get(1));
//        System.out.println(integers.size());

//        int first = ThreadLocalRandom.current().nextInt(0, 10);
//        int last = 0;
//        int ex = 0;
//        System.out.println(first);
//        if (first == 0 || first == 10-1){
//            last = ThreadLocalRandom.current().nextInt(1, 10-1);
//        }else {
//            do {
//                last = ThreadLocalRandom.current().nextInt(0,10);
//            }while (first == last);
//        }
//        System.out.println(first + "/" +  last + "/" + ex);
//        if (last < first){
//            ex = last;
//            last = first;
//            first = ex;
//        }
//        System.out.println(first + "/" +  last + "/" + ex);

        //****************************************
//        Scanner scanner = new Scanner(System.in);
//
//        List<Integer> lower = new ArrayList<>();
//        List<Integer> upper = new ArrayList<>();
//        lower.add(5);
//        upper.add(15);
//        int a = 0;
//        while (a == 0){
//            int num = scanner.nextInt();
//            if (num != 0 && (num < lower.get(0) || num > upper.get(0))){
//                a = 1;
//                System.out.println("bumanzu");
//            }
//        }
//        int boder = 0;
//        int materialType = 0;
//        int sum = 10;
//        List<Integer> suppliersNum = new ArrayList<>();
//        List<Integer> demand = new ArrayList<>();
//        List<IntegerAllele> copy = new ArrayList<>();
//        List<Integer> lower= new ArrayList<>();
//        List<Integer> upper = new ArrayList<>();
//        suppliersNum.add(1);
//        suppliersNum.add(1);
//        demand.add(0);
//        demand.add(0);
//
//        copy.add(new IntegerAllele(5));
//        copy.add(new IntegerAllele(5));
//
//
//        lower.add(0);
//        lower.add(0);
//
//        upper.add(7);
//        upper.add(8);
//
//        List<AbstractObjectiveFunction> objectiveFunctions = new ArrayList<>();
//        objectiveFunctions.add(new Func1());
//        objectiveFunctions.add(new Func2());
//        InitializePop initializePop = new InitializePop(lower, upper, suppliersNum, demand, objectiveFunctions, new Chromosome(copy));
//        List<Chromosome> chromosomeList = new ArrayList<>();
//
//        chromosomeList.add(new Chromosome(copy));
//        copy.set(0,new IntegerAllele(1));
//        copy.set(1,new IntegerAllele(4));
//        chromosomeList.add(new Chromosome(copy));
//        copy.set(0,new IntegerAllele(4));
//        copy.set(1,new IntegerAllele(1));
//        chromosomeList.add(new Chromosome(copy));
//        copy.set(0,new IntegerAllele(7));
//        copy.set(1,new IntegerAllele(3));
//        chromosomeList.add(new Chromosome(copy));
//        List<Chromosome> chromosomes = initializePop.sortPopulation(new Population(chromosomeList));
//        System.out.println(Arrays.toString(chromosomes.toArray()));
//        System.out.println(chromosomes.get(1).getRank() + "---" + chromosomes.get(1).getCrowdingDistance());
//        for (int i =2;i < 2;i++){
//            System.out.println(i);
//        }
//        demandFxi(boder, materialType, sum, suppliersNum, demand, copy, upper);
//        System.out.println("//////" + copy.get(0).getGene());
//        System.out.println(copy.get(1).getGene());
//        System.out.println(copy.get(2).getGene());
//        System.out.println(copy.get(3).getGene());
//        System.out.println(copy.get(4).getGene());

//        if (sum < demand.get(materialType)){
//            demandFxi(boder, materialType, sum, suppliersNum, demand, copy, upper);
//        }else if (sum >= demand.get(materialType)){
//            System.out.println("get an answer");
//        }
//        for (IntegerAllele integerAllele : copy) {
//            System.out.println(integerAllele.getGene() + "/");
//        }

    }
    //计算欧几里得距离
    public static double calculateEuclideanDistance(Chromosome chromosome1, Chromosome chromosome2){
        double x = chromosome1.getObjectiveValue(0) - chromosome2.getObjectiveValue(0);
        double y = chromosome1.getObjectiveValue(1) - chromosome2.getObjectiveValue(1);
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    /**
     * HV计算
     * @param PF 前沿解集()
     * @param r 参考点的xy坐标
     * @return 超体积(HV)值，越大代表算法性能越好
     */
    public static double calculateHV(List<Chromosome> PF, List<Double> r){
        double HV = 0;
        if (r.size() != 2){
            throw new UnsupportedOperationException("参考点坐标设置错误，应只包含x、y两个坐标");
        }
        for (int i = 0; i < PF.size(); i++){
            if (i == 0){
                HV += Math.abs(PF.get(i).getObjectiveValue(0) - r.get(0)) * Math.abs(PF.get(i).getObjectiveValue(1) - r.get(1));
            }else {
                HV += Math.abs(PF.get(i).getObjectiveValue(0) - r.get(0)) * Math.abs(PF.get(i).getObjectiveValue(1) - PF.get(i-1).getObjectiveValue(1));
            }
        }
        return HV;
    }

    /**
     * 计算DM指标
     * @param df 最大极端解和最大边界解（2个染色体）
     * @param dl 最小极端解和最小边界解（2个染色体）
     * @param PF 前沿解集
     * @return DM指标值，其值越小表示非支配解的分布性和多样性越好
     */
    public static double calculateDM(List<Chromosome> df, List<Chromosome> dl, List<Chromosome> PF){
        Chromosome chromosome1 = df.get(0);
        Chromosome chromosome2 = df.get(1);
        Chromosome chromosome3 = dl.get(0);
        Chromosome chromosome4 = dl.get(1);
        double f = calculateEuclideanDistance(chromosome1,chromosome2);
        double l = calculateEuclideanDistance(chromosome3,chromosome4);
        double avgD = 0;
        for (int i = 0; i < PF.size() - 1; i++){
            avgD += calculateEuclideanDistance(PF.get(i),PF.get(i+1));
        }
        avgD = avgD / (PF.size() - 1);
        double abs = 0;
        for (int i = 0; i < PF.size() - 1; i++){
            abs += Math.abs(calculateEuclideanDistance(PF.get(i), PF.get(i + 1)) - avgD);
        }
        return (f + l + abs) / (f + l + (PF.size() - 1) * avgD);
    }

    //去除重复染色体
    public static List<Chromosome> deleteDuplicate(List<Chromosome> originalChromosomes){
        List<Chromosome> chromosomes = new ArrayList<>();
        chromosomes.add(originalChromosomes.get(0));
        int j = 0;
        for (int i = 1; i < originalChromosomes.size(); i++){
            if (!originalChromosomes.get(i).identicalGeneticCode(chromosomes.get(j))){
                chromosomes.add(originalChromosomes.get(i));
                j++;
            }
        }
        return chromosomes;
    }

    /**
     * 计算Coverage metric指标，比较AB两条PF优劣
     * @param PF1 第一条解集
     * @param PF2 第二条解集
     * @param objectives 两个目标函数
     * @return 一个集合，包含C(PF1,PF2)和C(PF2,PF1)两个值
     */
    public static List<Double> calculateCM(List<Chromosome> PF1, List<Chromosome> PF2, List<AbstractObjectiveFunction> objectives){
        List<Chromosome> allPF = new ArrayList<>(PF1);
        allPF.addAll(PF2);
        List<Chromosome> chromosomes = sortPopulation(new Population(allPF), objectives);

        //统计两条前沿解集被支配的部分
        int pf1 = 0;
        int pf2 = 0;
        List<Chromosome> weedOut = new ArrayList<>();

        int count = 0;
        while (count < chromosomes.size()){
            if (chromosomes.get(count).getRank() != 1){
                weedOut.add(chromosomes.get(count));
            }
            count++;
        }
        for (int i = 0; i < weedOut.size(); i++){
            //PF2支配PF1
            for (int j = 0; j < PF1.size(); j++){
                if (weedOut.get(i).identicalGeneticCode(PF1.get(j))){
                    pf1++;
                }
            }
            for (int k = 0; k < PF2.size(); k++){
                if (weedOut.get(i).identicalGeneticCode(PF2.get(k))){
                    pf2++;
                }
            }
        }
        double c12 =  pf2 / (double)PF2.size();
        double c21 =  pf1 / (double)PF1.size();
        List<Double> answer = new ArrayList<>();
        answer.add(c12);
        answer.add(c21);

        return answer;
    }

    //获得排序并且去掉重复染色体后的前沿解集
    public static List<Chromosome> getListChromosomeWithoutDuplicate(Population runResult){
        List<Chromosome> populace = runResult.getPopulace();
        List<Chromosome> rankNSGA2 = new ArrayList<>();
        boolean rank1 = true;
        while (rank1){
            for (Chromosome chromosome : populace) {
                if (chromosome.getRank() == 1) {
                    rankNSGA2.add(chromosome);
                } else {
                    break;
                }
            }
            rank1 = false;
        }
        return deleteDuplicate(rankNSGA2);
    }

    //记录下最大最小极端染色体
    public static List<Chromosome> getBorderChromosome(Population runResult1, Population runResult2){
        //记录下最大、最小极端解的染色体
        List<Chromosome> borderChromosome = new ArrayList<>();
        if (getListChromosomeWithoutDuplicate(runResult1).get(0).getObjectiveValue(0) <= getListChromosomeWithoutDuplicate(runResult2).get(0).getObjectiveValue(0)){
            borderChromosome.add(getListChromosomeWithoutDuplicate(runResult1).get(0));
        }else {
            borderChromosome.add(getListChromosomeWithoutDuplicate(runResult2).get(0));
        }
        if (getListChromosomeWithoutDuplicate(runResult1).get(getListChromosomeWithoutDuplicate(runResult1).size() - 1).getObjectiveValue(0) >= getListChromosomeWithoutDuplicate(runResult2).get(getListChromosomeWithoutDuplicate(runResult2).size() - 1).getObjectiveValue(0)){
            borderChromosome.add(getListChromosomeWithoutDuplicate(runResult1).get(getListChromosomeWithoutDuplicate(runResult1).size() - 1));
        }else {
            borderChromosome.add(getListChromosomeWithoutDuplicate(runResult2).get(getListChromosomeWithoutDuplicate(runResult2).size() - 1));
        }
        return borderChromosome;
    }

    //2个CM计算（直接由run的结果）
    public static List<Double> getCMs(List<Chromosome> PF, List<Chromosome> IPF, List<AbstractObjectiveFunction> objectives){
//        return calculateCM(getListChromosomeWithoutDuplicate(runResult1), getListChromosomeWithoutDuplicate(runResult2), objectives);
        return calculateCM(PF, IPF, objectives);
    }
    //2个DM计算
    public static List<Double> getDMs(List<Chromosome> PF, List<Chromosome> IPF, List<Chromosome> border){
        List<Double> DMs = new ArrayList<>();
        List<Chromosome> dfNSGA2 = new ArrayList<>();
        List<Chromosome> dlNSGA2 = new ArrayList<>();
        dfNSGA2.add(border.get(0));
        dfNSGA2.add(PF.get(0));
        dlNSGA2.add(border.get(1));
        dlNSGA2.add(PF.get(PF.size() - 1));
        double NSGA2DM = calculateDM(dfNSGA2, dlNSGA2, PF);

        List<Chromosome> dfINSGA2 = new ArrayList<>();
        List<Chromosome> dlINSGA2 = new ArrayList<>();
        dfINSGA2.add(border.get(0));
        dfINSGA2.add(IPF.get(0));
        dlINSGA2.add(border.get(1));
        dlINSGA2.add(IPF.get(IPF.size() - 1));
        double INSGA2DM = calculateDM(dfINSGA2, dlINSGA2, IPF);

        DMs.add(NSGA2DM);
        DMs.add(INSGA2DM);

        return DMs;
    }

    //2个HV计算
    public static List<Double> getHVs(List<Chromosome> PF, List<Chromosome> IPF, List<Chromosome> border){
        List<Double> r = new ArrayList<>();
        List<Double> HVs = new ArrayList<>();
        r.add(border.get(1).getObjectiveValue(0) * 1.1);
        r.add(border.get(0).getObjectiveValue(1) * 1.1);
        double NSGA2HV = calculateHV(PF, r);
        double INSGA2HV = calculateHV(IPF, r);

        HVs.add(NSGA2HV);
        HVs.add(INSGA2HV);

        return HVs;
    }

    //选择物料中供应商并修改其供应量，直至满足
    private static void demandFxi(int border, int materialType, int sum, List<Integer> suppliersNum, List<Integer> demand, List<IntegerAllele> copy, List<Integer> upper) {
        int x = ThreadLocalRandom.current().nextInt(border,border + suppliersNum.get(materialType));
        //设置其订单量以满足需求
        int x_value = demand.get(materialType) - sum + copy.get(x).getGene();
        //如果超过最大订单量，再重新选择
        if (x_value <= upper.get(x)){
            copy.set(x,new IntegerAllele(x_value));
        }else {
            sum = sum + upper.get(x) - copy.get(x).getGene();
            copy.set(x,new IntegerAllele(upper.get(x)));
            //需求修复方法
            demandFxi(border,materialType,sum,suppliersNum,demand,copy,upper);
        }

    }

    //将局部解集按照拥挤度排序，参考NSGA2中preparePopulation方法
    public static List<Chromosome> sortPopulation(Population population, List<AbstractObjectiveFunction> objectives) {
        Service.calculateObjectiveValues(population, objectives);
        fastNonDominatedSort(population, objectives);
        crowdingDistanceAssignment(population, objectives);
        population.getPopulace().sort(Comparator.comparingInt(Chromosome::getRank));

        return population.getPopulace();
    }
    //
    public static void fastNonDominatedSort(Population population, List<AbstractObjectiveFunction> objectives) {

        List<Chromosome> populace = population.getPopulace();

        for(Chromosome chromosome : populace)
            chromosome.reset();

        for(int i = 0; i < populace.size() - 1; i++) {
            for (int j = i + 1; j < populace.size(); j++)
                switch (dominates(populace.get(i), populace.get(j), objectives)) {

                    case InitializePop.DOMINANT:

                        populace.get(i).addDominatedChromosome(populace.get(j));
                        populace.get(j).incrementDominatedCount(1);
                        break;

                    case InitializePop.INFERIOR:

                        populace.get(i).incrementDominatedCount(1);
                        populace.get(j).addDominatedChromosome(populace.get(i));
                        break;

                    case InitializePop.NON_DOMINATED:
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
    public static void crowdingDistanceAssignment(Population population, List<AbstractObjectiveFunction> objectives) {

        int size = population.size();

        for(int i = 0; i < objectives.size(); i++) {

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
    public static int dominates(Chromosome chromosome1, Chromosome chromosome2, List<AbstractObjectiveFunction> objectives) {

        if(isDominant(chromosome1, chromosome2, objectives)) return InitializePop.DOMINANT;
        else if(isDominant(chromosome2, chromosome1, objectives)) return InitializePop.INFERIOR;
        else return InitializePop.NON_DOMINATED;
    }
    //
    public static boolean isDominant(Chromosome chromosome1, Chromosome chromosome2, List<AbstractObjectiveFunction> objectives) {

        boolean atLeastOneIsBetter = false;

        for(int i = 0; i < objectives.size(); i++)
            if(chromosome1.getObjectiveValues().get(i) > chromosome2.getObjectiveValues().get(i))
                return false;
            else if(chromosome1.getObjectiveValues().get(i) < chromosome2.getObjectiveValues().get(i))
                atLeastOneIsBetter = true;

        return atLeastOneIsBetter;
    }

}
