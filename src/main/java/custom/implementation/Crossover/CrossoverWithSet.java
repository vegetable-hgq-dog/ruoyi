package custom.implementation.Crossover;

import com.debacharya.nsgaii.crossover.AbstractCrossover;
import com.debacharya.nsgaii.crossover.CrossoverParticipantCreator;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.datastructure.Population;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairMechanism;
import custom.implementation.improved.RepairWithoutSet;

import java.util.ArrayList;
import java.util.List;

public class CrossoverWithSet extends AbstractCrossover {

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

    public CrossoverWithSet(CrossoverParticipantCreator crossoverParticipantCreator, float crossoverProbability,
                            List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum,
                            List<Integer> demand, List<Double> dq, List<Double> de, int cr,
                            double deliveryDate, List<Double> tp, List<Double> transportDate) {
        super(crossoverParticipantCreator, crossoverProbability);
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
        List<IntegerAllele> geneticCode = new ArrayList<>();
        ConstraintFactor constraintFactor = new ConstraintFactor();

        //交叉后，不满足的话采用修复机制
        //考虑需求和齐套的情况
        for (int i = 0; i < chromosome1.getLength(); i++){
            switch (Math.random() <= 0.5 ? 1 : 2) {
                case 1:
                    geneticCode.add(i,(IntegerAllele) chromosome1.getGeneticCode().get(i).getCopy());
                    break;
                case 2:
                    geneticCode.add(i,(IntegerAllele) chromosome2.getGeneticCode().get(i).getCopy());
                    break;
            }
        }
        if (constraintFactor.satisfyDemand(geneticCode,suppliersNum,demand) && constraintFactor.satisfyOrderFulfillment(geneticCode,suppliersNum,demand,dq,de,cr)){
            return new Chromosome(geneticCode);
        }else {
            List<IntegerAllele> repaired = new RepairMechanism().repair1(new Chromosome(geneticCode),lower,upper,suppliersNum,demand,dq,de,cr,deliveryDate,tp,transportDate);
            return new Chromosome(repaired);
        }

    }

}
