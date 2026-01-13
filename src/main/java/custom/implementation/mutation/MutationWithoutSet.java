package custom.implementation.mutation;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.mutation.AbstractMutation;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairWithoutSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MutationWithoutSet extends AbstractMutation {

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Integer> lower;
    private final List<Integer> upper;

    public MutationWithoutSet(float mutationProbability, List<Integer> suppliersNum,
                                      List<Integer> demand, List<Integer> lower, List<Integer> upper){
        super(mutationProbability);
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public Chromosome perform(Chromosome chromosome){
        List<IntegerAllele> integerGeneticCode = new ArrayList<>();
        ConstraintFactor constraintFactor = new ConstraintFactor();

        for (int i = 0; i < chromosome.getLength(); i++){
            if (this.shouldPerformMutation()){
                integerGeneticCode.add(i,new IntegerAllele(orderGenerate(i,lower,upper)));
            }else {
                integerGeneticCode.add(i,new IntegerAllele(((IntegerAllele)chromosome.getAllele(i)).getGene()));
            }
        }
        if (constraintFactor.satisfyDemand(integerGeneticCode,suppliersNum,demand)){
            return new Chromosome(integerGeneticCode);
        }else {
            List<IntegerAllele> repaired = new RepairWithoutSet().repair(new Chromosome(integerGeneticCode), lower, upper, suppliersNum, demand);
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
