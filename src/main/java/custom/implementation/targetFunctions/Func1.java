package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.List;
import java.util.stream.Collectors;

public class Func1  extends AbstractObjectiveFunction {
//    public Func1() {
//        this.objectiveFunctionTitle = "min[-x1+x2]";
//    }

    public Func1() {
        this.objectiveFunctionTitle = "min[200x1+270x2+330x3+400x4+350x5]";
    }

    @Override
    public double getValue(Chromosome chromosome) {
        List<IntegerAllele> geneticCode = chromosome.getGeneticCode().stream().map(e -> (IntegerAllele) e).collect(Collectors.toList());
        int size = geneticCode.size();
        double sum = 0;

//        for(int i = 0; i < size; i++){
//            int factor = 0;
//            if (i == 0){
//                factor = -1;
//            }else if (i == 1){
//                factor = 1;
//            }
//            sum += geneticCode.get(i).getGene() * factor;
//        }
        for(int i = 0; i < size; i++){
            int factor = 0;
            if (i == 0){
                factor = 200;
            }else if (i == 1){
                factor = 270;
            }else if (i == 2){
                factor = 330;
            }else if (i == 3){
                factor = 400;
            }else if (i == 4){
                factor = 350;
            }
            sum += geneticCode.get(i).getGene() * factor;
        }
        return sum;
    }
}
