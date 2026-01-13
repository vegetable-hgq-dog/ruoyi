package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.ValueAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.stream.Collectors;

public class Function1  extends AbstractObjectiveFunction {

    public Function1() {
        this.objectiveFunctionTitle = "min(x1)";
    }

    @Override
    public double getValue(Chromosome chromosome) {
        return chromosome.getGeneticCode().stream().map(e -> (ValueAllele) e).collect(Collectors.toList()).get(0).getGene();
    }

}
