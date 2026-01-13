package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

public class ConstantFunction extends AbstractObjectiveFunction {

    public ConstantFunction() {
        this.objectiveFunctionTitle = "constant=10";
    }

    @Override
    public double getValue(Chromosome chromosome) {
        return 10;
    }
}
