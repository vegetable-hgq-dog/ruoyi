package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.List;
import java.util.stream.Collectors;

public class unqualifiedQuantity extends AbstractObjectiveFunction {

    private final List<Double> dq;
    private final List<Double> de;

    public unqualifiedQuantity(List<Double> dq, List<Double> de) {
        this.objectiveFunctionTitle  = "unqualifiedQuantity";
        this.dq = dq;
        this.de = de;
    }

    @Override
    public double getValue(Chromosome chromosome) {

        List<IntegerAllele> geneticCode = chromosome.getGeneticCode().stream().map(e -> (IntegerAllele) e).collect(Collectors.toList());
        double xyq = 0;
        double xye = 0;

        for (int i = 0; i < geneticCode.size(); i++){
            xyq += geneticCode.get(i).getGene() * dq.get(i);
            xye += geneticCode.get(i).getGene() * de.get(i);
        }
        //xyq + xye即为不合格物料总数量，包含次品数量和延迟数量
        return Math.floor(xyq) + Math.floor(xye);
    }
}
