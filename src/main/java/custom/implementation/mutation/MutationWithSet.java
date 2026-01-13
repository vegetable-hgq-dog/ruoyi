package custom.implementation.mutation;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.mutation.AbstractMutation;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairMechanism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MutationWithSet extends AbstractMutation {

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

    public MutationWithSet(float mutationProbability, List<Integer> lower,
                           List<Integer> upper, List<Integer> suppliersNum,
                           List<Integer> demand, List<Double> dq, List<Double> de,
                           int cr, double deliveryDate, List<Double> tp, List<Double> transportDate) {
        super(mutationProbability);
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
    }

    @Override
    public Chromosome perform(Chromosome chromosome) {
        List<IntegerAllele> integerGeneticCode = new ArrayList<>();
        ConstraintFactor constraintFactor = new ConstraintFactor();
        List<Boolean> suppliersChoose = constraintFactor.suppliersChoose(deliveryDate, tp, transportDate, lower);
        List<Integer> upperOrder = constraintFactor.getUpperOrder(deliveryDate, tp, transportDate, upper);

        for (int i = 0; i < chromosome.getLength(); i++){
            if (this.shouldPerformMutation()){
                if (suppliersChoose.get(i)){
                    integerGeneticCode.add(i,new IntegerAllele(orderGenerate(i,lower,upperOrder)));
                }else {
                    integerGeneticCode.add(i,new IntegerAllele(0));
                }
            }else {
                integerGeneticCode.add(i,new IntegerAllele(((IntegerAllele)chromosome.getAllele(i)).getGene()));
            }
        }
        if (constraintFactor.satisfyDemand(integerGeneticCode,suppliersNum,demand) && constraintFactor.satisfyOrderFulfillment(integerGeneticCode,suppliersNum,demand,dq,de,cr)){
            return new Chromosome(integerGeneticCode);
        }else {
            List<IntegerAllele> repaired = new RepairMechanism().repair1(new Chromosome(integerGeneticCode), lower, upper, suppliersNum, demand,dq,de,cr,deliveryDate,tp,transportDate);
            return new Chromosome(repaired);
        }
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
