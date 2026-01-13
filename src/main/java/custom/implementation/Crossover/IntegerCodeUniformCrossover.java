package custom.implementation.Crossover;

import com.debacharya.nsgaii.crossover.AbstractCrossover;
import com.debacharya.nsgaii.crossover.CrossoverParticipantCreator;
import com.debacharya.nsgaii.datastructure.AbstractAllele;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.datastructure.Population;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairMechanism;

import java.util.ArrayList;
import java.util.List;

//不带修复机制
public class IntegerCodeUniformCrossover extends AbstractCrossover {

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;

    private List<Double> dq;
    private List<Double> de;
    private int cr;


    public IntegerCodeUniformCrossover(CrossoverParticipantCreator crossoverParticipantCreator,float crossoverProbability,
                                       List<Integer> suppliersNum, List<Integer> demand, List<Double> dq,
                                       List<Double> de, int cr) {
        super(crossoverParticipantCreator,crossoverProbability);
        this.suppliersNum = suppliersNum;
        this.demand = demand;

        this.dq = dq;
        this.de = de;
        this.cr = cr;

    }

//    public IntegerCodeUniformCrossover(CrossoverParticipantCreator crossoverParticipantCreator,float crossoverProbability,
//                                       List<Integer> suppliersNum, List<Integer> demand) {
//        super(crossoverParticipantCreator,crossoverProbability);
//        this.suppliersNum = suppliersNum;
//        this.demand = demand;
//
//    }


    @Override
    public List<Chromosome> perform(Population population) {
        List<Chromosome> result = new ArrayList<>();
        //通过二进制锦标选择
        List<Chromosome> selected = this.crossoverParticipantCreator.create(population);

        if(this.shouldPerformCrossover())
            for(int i = 0; i < 2; i++)
                result.add(
                        this.prepareChildChromosome(
                                selected.get(0),
                                selected.get(1)
                        )
                );
        else {
            result.add(selected.get(0).getCopy());
            result.add(selected.get(1).getCopy());
        }

        return result;
    }

    private Chromosome prepareChildChromosome(Chromosome chromosome1, Chromosome chromosome2){

        ConstraintFactor constraintFactor = new ConstraintFactor();
        List<IntegerAllele> geneticCode = new ArrayList<>();

//        List<Integer> upperOrder = constraintFactor.getUpperOrder(deliveryDate, tp, transportDate, upper);
//        //交叉后，不满足的话采用修复机制
//        //考虑需求和齐套的情况
//        for (int i = 0; i < chromosome1.getLength(); i++){
//            switch (Math.random() <= 0.5 ? 1 : 2) {
//                case 1:
//                    geneticCode.add(i,(IntegerAllele) chromosome1.getGeneticCode().get(i).getCopy());
//                    break;
//                case 2:
//                    geneticCode.add(i,(IntegerAllele) chromosome2.getGeneticCode().get(i).getCopy());
//                    break;
//                }
//        }
//        if (constraintFactor.satisfyDemand(geneticCode,suppliersNum,demand) && constraintFactor.satisfyOrderFulfillment(geneticCode,suppliersNum,demand,dq,de,cr)){
//            return new Chromosome(geneticCode);
//        }else {
//            List<IntegerAllele> repaired = new RepairMechanism().repair1(new Chromosome(geneticCode),lower,upperOrder,suppliersNum,demand,dq,de,cr,deliveryDate,tp,transportDate);
//            return new Chromosome(repaired);
//        }

        //--------------------------------------------
        //suppliers应该是第几种物料
        //仅仅考虑需求的情况
        int suppliers = 0;
        int sum = 0;
        int count = 0;
        int totalNum = 0;
        int qualified = 0;

        while(suppliers < suppliersNum.size()) {
            if (count < suppliersNum.get(suppliers) + totalNum && count < chromosome1.getLength()){
                switch (Math.random() <= 0.5 ? 1 : 2) {
                    case 1:
                        IntegerAllele chr1 = (IntegerAllele) chromosome1.getGeneticCode().get(count).getCopy();
                        int value1 = chr1.getGene();
                        qualified += (int)Math.floor(value1 * (1 - dq.get(count) - de.get(count)));
                        sum += value1;

                        if (geneticCode.size() == count){
                            geneticCode.add(count++, chr1);
                        }else {
                            geneticCode.set(count++, chr1);
                        }

                        break;
                    case 2:
                        IntegerAllele chr2 = (IntegerAllele)chromosome2.getGeneticCode().get(count).getCopy();
                        int value2 = chr2.getGene();
                        qualified += (int)Math.floor(value2 * (1 - dq.get(count) - de.get(count)));
                        sum += value2;

                        if (geneticCode.size() == count){
                            geneticCode.add(count++, chr2);
                        }else {
                            geneticCode.set(count++, chr2);
                        }

                        break;
                }
            }else {
                //如果不能满足需求，则重新交叉
                if (sum < demand.get(suppliers) || qualified / (double)demand.get(suppliers) < cr/100.0){
                    count = count - suppliersNum.get(suppliers);
                    sum = 0;
                }else {
                    totalNum += suppliersNum.get(suppliers);
                    sum = 0;
                    suppliers++;
                }
            }
        }
    return new Chromosome(geneticCode);
        //--------------------------------------
    }

}
