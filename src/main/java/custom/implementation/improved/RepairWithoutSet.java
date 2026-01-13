package custom.implementation.improved;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import custom.implementation.constraint.ConstraintFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RepairWithoutSet {

    //输入的染色体提前判断了不满足约束，输出修复后的染色体
    public List<IntegerAllele> repair(Chromosome beforeRepairChromosome, List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum, List<Integer> demand){
        ConstraintFactor constraintFactor = new ConstraintFactor();
        //假设情况：全部供应商都供应的话，不存在无法满足需求的情况,不存在无法满足齐套要求的情况
        List<IntegerAllele> maxSupply = new ArrayList<>();
        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
            maxSupply.add(i,new IntegerAllele(upper.get(i)));
        }
        if (!constraintFactor.satisfyDemand(maxSupply,suppliersNum,demand)){
            throw new UnsupportedOperationException("The target suppliers cannot meet the demand, and need more suppliers");
        }

        List<IntegerAllele> copy = new ArrayList<>();
        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
            copy.add(i,(IntegerAllele) beforeRepairChromosome.getGeneticCode().get(i).getCopy());
        }
        //第一步：判断每个供应商是否被选择，是否满足起订量以及是否超过订单量
        for (int i = 0; i < copy.size(); i++){
            int value = copy.get(i).getGene();
            //如果不满足,不足起订量的随机设置为0或最小起订量；超过最大订单量的设置为最大订单量
            if (value != 0 && (value < lower.get(i) || value > upper.get(i))){
                if (value < lower.get(i)){
                    switch (Math.random() <= 0.5 ? 1 : 2){
                        case 1: copy.set(i,new IntegerAllele(0));break;
                        case 2: copy.set(i,new IntegerAllele(lower.get(i)));break;
                    }
                }else {
                    copy.set(i,new IntegerAllele(upper.get(i)));
                }
            }
        }
        //第二步：检查每种物料是否满足需求以及齐套率[暂未实现齐套部分代码]
        int materialType = 0;
        int sum = 0;
        int count = 0;
        int border = 0;

        while(materialType < suppliersNum.size()){
            if (count < suppliersNum.get(materialType) + border && count < copy.size()){
                sum += copy.get(count++).getGene();
            }else {
                if (sum < demand.get(materialType)){
                    demandFxi(border,materialType,sum,suppliersNum,demand,copy,upper);
                }
                border += suppliersNum.get(materialType);
                sum = 0;
                materialType++;
            }
        }
        return copy;
    }

    private void demandFxi(int border, int materialType, int sum, List<Integer> suppliersNum, List<Integer> demand,
                           List<IntegerAllele> copy, List<Integer> upper) {
        //01-24:确保x这个供应商可以选择用来修复染色体（不能为0）
        int x = ThreadLocalRandom.current().nextInt(border,border + suppliersNum.get(materialType));
        //设置其订单量以满足需求
        int x_value = demand.get(materialType) - sum + copy.get(x).getGene();
        //如果超过最大订单量，再重新选择
        if (x_value <= upper.get(x)){
            copy.set(x,new IntegerAllele(x_value));

        }else {
            sum = sum + upper.get(x) - copy.get(x).getGene();
            copy.set(x,new IntegerAllele(upper.get(x)));
            //需求修复方法
            demandFxi(border,materialType,sum,suppliersNum,demand,copy,upper);
        }

    }
}
