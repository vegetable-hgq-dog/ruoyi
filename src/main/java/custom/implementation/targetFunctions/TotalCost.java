package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;
import custom.implementation.constraint.ConstraintFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TotalCost extends AbstractObjectiveFunction {

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Double> dq;
    private final List<Double> de;

    public TotalCost(List<Integer> suppliersNum, List<Integer> demand,
                     List<Double> dq, List<Double> de) {
        this.objectiveFunctionTitle  = "cost";
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.dq = dq;
        this.de = de;
    }

    @Override
    public double getValue(Chromosome chromosome) {
        List<IntegerAllele> geneticCode = chromosome.getGeneticCode().stream().map(e -> (IntegerAllele) e).collect(Collectors.toList());
        //Ft表示齐套程度
        List<Double> Ft = new ArrayList<>();
        Ft.add(0,1.0);

        int materialType = 0;
        int qualified = 0;
        int count = 0;
        int border = 0;
        //统计每种物料的运输、购买成本，由于染色体生成变异等过程，一旦供应商不满足交期约束不被选择时，x被设置为0，此时简化了y
        int xyb = 0;
        int xyf = 0;
        //其中50000为假设的空调需求产量Qt，200为少生产1台损失的成本l（元）,cb和cf为购买成本及运输成本，包含全部供应商的，长度和染色体相同
        int l = 300;
        int Qt = 900;
        List<Double> cb = new ArrayList<>();
        List<Double> cf = new ArrayList<>();

        cb.add(460.0);
        cb.add(325.0);
        cb.add(51.0);
        cb.add(45.0);
        cb.add(38.0);
        cb.add(32.0);
        cb.add(53.0);
        cb.add(400.0);
        cb.add(286.0);
        cb.add(335.0);

        cf.add(20.0);
        cf.add(35.0);
        cf.add(2.0);
        cf.add(3.0);
        cf.add(6.0);
        cf.add(2.0);
        cf.add(5.0);
        cf.add(15.0);
        cf.add(30.0);
        cf.add(25.0);


        while(materialType < suppliersNum.size()){
            if (count < suppliersNum.get(materialType) + border && count < geneticCode.size()){
                qualified += (int)Math.floor(geneticCode.get(count).getGene() * (1 - dq.get(count) - de.get(count)));
                xyb += cb.get(count) * geneticCode.get(count).getGene();
                xyf += cf.get(count) * geneticCode.get(count).getGene();
                count++;
            }else {
                double cr = qualified / (double) demand.get(materialType);
                if (cr <= Ft.get(0)){
                    Ft.set(0,cr);
                }
                border += suppliersNum.get(materialType);
                qualified = 0;
                materialType++;
            }
        }
        //未完成预期产能的损失成本
        double Cl = l * (1 - Ft.get(0)) * Qt;
        double Cb = xyb;
        double Cf = xyf;

        return Cl + Cb + Cf;
    }
}
