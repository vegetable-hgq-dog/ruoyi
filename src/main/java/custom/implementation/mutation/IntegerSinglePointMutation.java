package custom.implementation.mutation;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.mutation.AbstractMutation;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairMechanism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//不带修复机制
public class IntegerSinglePointMutation extends AbstractMutation {

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Integer> lower;
    private final List<Integer> upper;
    private List<Double> dq;
    private List<Double> de;
    private int cr;
    private double deliveryDate;
    private List<Double> tp;
    private List<Double> transportDate;

    public IntegerSinglePointMutation(float mutationProbability, List<Integer> suppliersNum,
                                      List<Integer> demand, List<Integer> lower,
                                      List<Integer> upper, List<Double> dq, List<Double> de, int cr,
                                      double deliveryDate, List<Double> tp, List<Double> transportDate) {
        super(mutationProbability);
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.lower = lower;
        this.upper = upper;
        this.dq = dq;
        this.de = de;
        this.cr = cr;
        this.deliveryDate = deliveryDate;
        this.tp = tp;
        this.transportDate = transportDate;
    }

//    public IntegerSinglePointMutation(float mutationProbability, List<Integer> suppliersNum,
//                                      List<Integer> demand, List<Integer> lower, List<Integer> upper){
//        super(mutationProbability);
//        this.suppliersNum = suppliersNum;
//        this.demand = demand;
//        this.lower = lower;
//        this.upper = upper;
//    }

    @Override
    public Chromosome perform(Chromosome chromosome) {

        List<IntegerAllele> integerGeneticCode = new ArrayList<>();
        ConstraintFactor constraintFactor = new ConstraintFactor();

//        List<Integer> upperOrder = constraintFactor.getUpperOrder(deliveryDate, tp, transportDate, upper);
//        for (int i = 0; i < chromosome.getLength(); i++){
//            if (this.shouldPerformMutation()){
//                integerGeneticCode.add(i,new IntegerAllele(orderGenerate(i,lower,upperOrder)));
//            }else {
//                integerGeneticCode.add(i,new IntegerAllele(((IntegerAllele)chromosome.getAllele(i)).getGene()));
//            }
//        }
//        if (constraintFactor.satisfyDemand(integerGeneticCode,suppliersNum,demand) && constraintFactor.satisfyOrderFulfillment(integerGeneticCode,suppliersNum,demand,dq,de,cr)){
//            return new Chromosome(integerGeneticCode);
//        }else {
//            List<IntegerAllele> repaired = new RepairMechanism().repair1(new Chromosome(integerGeneticCode), lower, upperOrder, suppliersNum, demand, dq, de, cr, deliveryDate, tp, transportDate);
//            return new Chromosome(repaired);
//        }
        //----------------------------------
        int suppliers = 0;
        int sum = 0;
        int count = 0;
        int totalNum = 0;
        int qualified = 0;
        List<Boolean> suppliersChoose = new ConstraintFactor().suppliersChoose(deliveryDate, tp, transportDate, lower);
        List<Integer> upperOrder = new ConstraintFactor().getUpperOrder(deliveryDate, tp, transportDate, upper);

        while (suppliers < suppliersNum.size()){
            //如果发生了变异
            if (this.shouldPerformMutation() && count < suppliersNum.get(suppliers) + totalNum && count < chromosome.getLength()){
                int mutation_value;
                if (suppliersChoose.get(count)){
                    mutation_value = orderGenerate(count,lower,upperOrder);
                }else {
                    mutation_value = 0;
                }
                qualified += (int)Math.floor(mutation_value * (1 - dq.get(count) - de.get(count)));
                sum += mutation_value;

                if (integerGeneticCode.size() == count){
                    integerGeneticCode.add(count++,new IntegerAllele(mutation_value));
                }else {
                    integerGeneticCode.set(count++,new IntegerAllele(mutation_value));
                }

            }else if (count < suppliersNum.get(suppliers) + totalNum){
                int value = ((IntegerAllele)chromosome.getAllele(count)).getGene();
                qualified += (int)Math.floor(value * (1 - dq.get(count) - de.get(count)));
                sum += value;

                if (integerGeneticCode.size() == count) {
                    integerGeneticCode.add(count++,new IntegerAllele(value));
                }else {
                    integerGeneticCode.set(count++,new IntegerAllele(value));
                }

            }else {

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
        return new Chromosome(integerGeneticCode);
        //-------------------------------------------------
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
}
