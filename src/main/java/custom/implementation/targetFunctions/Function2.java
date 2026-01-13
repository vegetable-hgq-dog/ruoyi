package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.ValueAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.List;
import java.util.stream.Collectors;

public class Function2 extends AbstractObjectiveFunction {

    public Function2(){
        this.objectiveFunctionTitle = "min(g(x) [1 - sqrt(x1 / g(x)])";
    }

    @Override
    public double getValue(Chromosome chromosome) {

        List<ValueAllele> geneticCode = chromosome.getGeneticCode().stream().map(e -> (ValueAllele) e).collect(Collectors.toList());
        double size = geneticCode.size();
        double sum = 0;

        for(int i = 1; i < size; i++)
            sum += geneticCode.get(i).getGene();

        double g = 1 + ((9 * sum) / size);
        double f = g * (1 - Math.sqrt(geneticCode.get(0).getGene() / g));

        return f;
    }
}
