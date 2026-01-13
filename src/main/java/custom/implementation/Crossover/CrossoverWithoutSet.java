package custom.implementation.Crossover;

import com.debacharya.nsgaii.crossover.AbstractCrossover;
import com.debacharya.nsgaii.crossover.CrossoverParticipantCreator;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.datastructure.Population;
import custom.implementation.constraint.ConstraintFactor;
import custom.implementation.improved.RepairWithoutSet;

import java.util.ArrayList;
import java.util.List;

public class CrossoverWithoutSet extends AbstractCrossover {

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Integer> lower;
    private final List<Integer> upper;

    public CrossoverWithoutSet(CrossoverParticipantCreator crossoverParticipantCreator, float crossoverProbability,
                                       List<Integer> suppliersNum, List<Integer> demand,
                                       List<Integer> lower, List<Integer> upper) {
        super(crossoverParticipantCreator,crossoverProbability);
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.lower = lower;
        this.upper = upper;
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
        if (constraintFactor.satisfyDemand(geneticCode,suppliersNum,demand)){
            return new Chromosome(geneticCode);
        }else {
            List<IntegerAllele> repaired = new RepairWithoutSet().repair(new Chromosome(geneticCode),lower,upper,suppliersNum,demand);
            return new Chromosome(repaired);
        }

    }
}
