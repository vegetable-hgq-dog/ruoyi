package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.List;
import java.util.stream.Collectors;

public class Func2 extends AbstractObjectiveFunction {

//    public Func2() {
//        this.objectiveFunctionTitle = "min[x1-x2]";
//    }

    public Func2() {
        this.objectiveFunctionTitle = "min[0.01x1+0.008x2+0.006x3+0.002x4+0.004x5]";
    }

    @Override
    public double getValue(Chromosome chromosome) {
        List<IntegerAllele> geneticCode = chromosome.getGeneticCode().stream().map(e -> (IntegerAllele) e).collect(Collectors.toList());
        int size = geneticCode.size();
        double sum = 0;

//        for(int i = 0; i < size; i++){
//            double factor = 0;
//            if (i == 0){
//                factor = 1;
//            }else if (i == 1){
//                factor = -1;
//            }
//            sum += geneticCode.get(i).getGene() * factor;
//        }
        for(int i = 0; i < size; i++){
            double factor = 0;
            if (i == 0){
                factor = 0.01;
            }else if (i == 1){
                factor = 0.008;
            }else if (i == 2){
                factor = 0.006;
            }else if (i == 3){
                factor = 0.002;
            }else if (i == 4){
                factor = 0.004;
            }
            sum += geneticCode.get(i).getGene() * factor;
        }
        return sum;
    }

}
