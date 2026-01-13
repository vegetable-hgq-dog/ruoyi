package custom.implementation.improved;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import custom.implementation.constraint.ConstraintFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//修复错误的不满足约束条件的染色体
public class RepairMechanism {

//    //输入的染色体提前判断了不满足约束，输出修复后的染色体
//    public List<IntegerAllele> repair(Chromosome beforeRepairChromosome, List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum, List<Integer> demand){
//        ConstraintFactor constraintFactor = new ConstraintFactor();
//        //假设情况：全部供应商都供应的话，不存在无法满足需求的情况,不存在无法满足齐套要求的情况
//        List<IntegerAllele> maxSupply = new ArrayList<>();
//        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
//            maxSupply.add(i,new IntegerAllele(upper.get(i)));
//        }
//        if (!constraintFactor.satisfyDemand(maxSupply,suppliersNum,demand)){
//            throw new UnsupportedOperationException("The target suppliers cannot meet the demand, and need more suppliers");
//        }
//
//        List<IntegerAllele> copy = new ArrayList<>();
//        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
//            copy.add(i,(IntegerAllele) beforeRepairChromosome.getGeneticCode().get(i).getCopy());
//        }
//        //第一步：判断每个供应商是否被选择，是否满足起订量以及是否超过订单量
//        for (int i = 0; i < copy.size(); i++){
//            int value = copy.get(i).getGene();
//            //如果不满足,不足起订量的随机设置为0或最小起订量；超过最大订单量的设置为最大订单量
//            if (value != 0 && (value < lower.get(i) || value > upper.get(i))){
//                if (value < lower.get(i)){
//                    switch (Math.random() <= 0.5 ? 1 : 2){
//                        case 1: copy.set(i,new IntegerAllele(0));break;
//                        case 2: copy.set(i,new IntegerAllele(lower.get(i)));break;
//                    }
//                }else {
//                    copy.set(i,new IntegerAllele(upper.get(i)));
//                }
//            }
//        }
//        //第二步：检查每种物料是否满足需求以及齐套率[暂未实现齐套部分代码]
//        int materialType = 0;
//        int sum = 0;
//        int count = 0;
//        int border = 0;
//
//        while(materialType < suppliersNum.size()){
//            if (count < suppliersNum.get(materialType) + border && count < copy.size()){
//                sum += copy.get(count++).getGene();
//            }else {
//                if (sum < demand.get(materialType)){
//                    demandFxi(border,materialType,sum,suppliersNum,demand,copy,upper);
//                }
//                border += suppliersNum.get(materialType);
//                sum = 0;
//                materialType++;
//            }
//        }
//        return copy;
//    }


    //输入的染色体提前判断了不满足约束，输出修复后的染色体

    /**
     *
     * @param beforeRepairChromosome 修复前的染色体
     * @param lower 订单起订量
     * @param upper 最大订单供应量
     * @param suppliersNum 每种物料对应的供应商数量
     * @param demand 物料各自需求
     * @param dq 次品率
     * @param de 延迟率
     * @param cr 齐套要求（%）[0,100]
     * @return 修复后的染色体基因数组
     */
    public List<IntegerAllele> repair1(Chromosome beforeRepairChromosome, List<Integer> lower, List<Integer> upper, List<Integer> suppliersNum, List<Integer> demand,
                                       List<Double> dq, List<Double> de, int cr, double deliveryDate, List<Double> tp, List<Double> transportDate){
        ConstraintFactor constraintFactor = new ConstraintFactor();
        //假设情况：全部供应商都供应的话，不存在无法满足需求的情况,不存在无法满足齐套要求的情况
        List<Integer> upperOrder = constraintFactor.getUpperOrder(deliveryDate, tp, transportDate, upper);
        List<Boolean> suppliersChoose = constraintFactor.suppliersChoose(deliveryDate, tp, transportDate, lower);
        List<IntegerAllele> maxSupply = new ArrayList<>();
        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
            if (suppliersChoose.get(i)){
                maxSupply.add(i,new IntegerAllele(upperOrder.get(i)));
            }else {
                maxSupply.add(i,new IntegerAllele(0));
            }
        }
        if (!constraintFactor.satisfyDemand(maxSupply,suppliersNum,demand) || !constraintFactor.satisfyOrderFulfillment(maxSupply,suppliersNum,demand,dq,de,cr)){
            throw new UnsupportedOperationException("The target suppliers cannot meet the demand, and need more suppliers");
        }

        List<IntegerAllele> copy = new ArrayList<>();
        for (int i = 0; i < beforeRepairChromosome.getLength(); i++){
            copy.add(i,(IntegerAllele) beforeRepairChromosome.getGeneticCode().get(i).getCopy());
        }
        //第一步：判断每个供应商是否被选择，是否满足起订量以及是否超过最大订单量
        for (int i = 0; i < copy.size(); i++){
            //判断是否被选择,不被选择则设置订单量为0
            if (!suppliersChoose.get(i)){
                copy.set(i,new IntegerAllele(0));
                continue;
            }

            int value = copy.get(i).getGene();
            //如果不满足,不足起订量的随机设置为0或最小起订量；超过最大订单量的设置为最大订单量
            if (value != 0 && (value < lower.get(i) || value > upperOrder.get(i))){
                if (value < lower.get(i)){
                    switch (Math.random() <= 0.5 ? 1 : 2){
                        case 1: copy.set(i,new IntegerAllele(0));break;
                        case 2: copy.set(i,new IntegerAllele(lower.get(i)));break;
                    }
                }else {
                    copy.set(i,new IntegerAllele(upperOrder.get(i)));
                }
            }
        }
        //第二步：检查每种物料是否满足需求以及齐套率
        //1、是否满足需求
        int materialType = 0;
        int sum = 0;
        int qualified = 0;
        int count = 0;
        int border = 0;

        while(materialType < suppliersNum.size()){
            if (count < suppliersNum.get(materialType) + border && count < copy.size()){
                qualified += (int)Math.floor(copy.get(count).getGene() * (1 - dq.get(count) - de.get(count)));
                sum += copy.get(count++).getGene();

            }else {
                if (sum < demand.get(materialType) || qualified / (double)demand.get(materialType) < cr/100.0){
                    demandFxi(border,materialType,sum,suppliersNum,demand,copy,lower,upperOrder,deliveryDate,tp,transportDate);
//                    orderFulfillmentFix(border,materialType,qualified,suppliersNum,demand,copy,lower,upper,dq,de,cr,deliveryDate,tp,transportDate);
                }
                border += suppliersNum.get(materialType);
                sum = 0;
                materialType++;
            }
        }
        //2、是否满足齐套，由于满足需求但不满足齐套时，只有通过提高供应量才能满足齐套，此时需求肯定过满足，所以无需再次判断需求是否满足约束
//        int qualified = 0;
//        materialType = 0;
//        count = 0;
//        border = 0;
//
//        while(materialType < suppliersNum.size()){
//            if (count < suppliersNum.get(materialType) + border && count < copy.size()){
//                qualified += (int)Math.floor(copy.get(count).getGene() * (1 - dq.get(count) - de.get(count)));
//                count++;
//            }else {
//                if (qualified / (double)demand.get(materialType) < cr/100.0){
//                    orderFulfillmentFix(border,materialType,qualified,suppliersNum,demand,copy,lower,upperOrder,dq,de,cr,deliveryDate,tp,transportDate);
//                }
//                border += suppliersNum.get(materialType);
//                qualified = 0;
//                materialType++;
//            }
//        }

        return copy;
    }

    //选择物料中供应商并修改其供应量，直至满足需求
    /**
     *
     * @param border 某个物料在染色体中起点
     * @param materialType 物料类型
     * @param sum 总需求
     * @param suppliersNum 每种物料对应的供应商数量
     * @param demand 物料各自需求
     * @param copy 染色体基因数组
     * @param upper 供应商最大供应量
     */
    private void demandFxi(int border, int materialType, int sum, List<Integer> suppliersNum, List<Integer> demand,
                           List<IntegerAllele> copy, List<Integer> lower, List<Integer> upper, double deliveryDate, List<Double> tp,
                           List<Double> transportDate) {
        //01-24:确保x这个供应商可以选择用来修复染色体（不能为0）
        int x = ThreadLocalRandom.current().nextInt(border,border + suppliersNum.get(materialType));
        List<Boolean> suppliersChoose = new ConstraintFactor().suppliersChoose(deliveryDate, tp, transportDate, lower);
        if (!suppliersChoose.get(x)){
            demandFxi(border,materialType,sum,suppliersNum,demand,copy,lower,upper,deliveryDate,tp,transportDate);
        }else {
            //设置其订单量以满足需求
            int x_value = demand.get(materialType) - sum + copy.get(x).getGene();
            //如果超过最大订单量，再重新选择
            if (x_value <= upper.get(x)){
                if (x_value <= lower.get(x) && x_value > 0){
                    copy.set(x,new IntegerAllele(lower.get(x)));
                }else if (x_value <= 0){
                    copy.set(x,new IntegerAllele(0));
                }else {
                    copy.set(x,new IntegerAllele(x_value));
                }

            }else {
                sum = sum + upper.get(x) - copy.get(x).getGene();
                copy.set(x,new IntegerAllele(upper.get(x)));
                //需求修复方法
                demandFxi(border,materialType,sum,suppliersNum,demand,copy,lower,upper,deliveryDate,tp,transportDate);
            }
        }
    }

    //选择物料中供应商并修改其供应量，直至满足齐套率

    /**
     *
     * @param border 某个物料在染色体中起点
     * @param materialType 物料类型
     * @param qualified 合格物料的总数量
     * @param suppliersNum 每种物料对应的供应商数量
     * @param demand 物料各自需求
     * @param copy 染色体基因数组
     * @param upper 供应商最大供应量
     * @param dq 次品率
     * @param de 延迟率
     * @param cr 齐套要求（%）[0,100]
     */
    private void orderFulfillmentFix(int border, int materialType, int qualified, List<Integer> suppliersNum,
                                     List<Integer> demand, List<IntegerAllele> copy, List<Integer> lower, List<Integer> upper,
                                     List<Double> dq, List<Double> de, int cr, double deliveryDate, List<Double> tp,
                                     List<Double> transportDate){
        int x = ThreadLocalRandom.current().nextInt(border,border + suppliersNum.get(materialType));
        List<Boolean> suppliersChoose = new ConstraintFactor().suppliersChoose(deliveryDate, tp, transportDate, lower);
        if (!suppliersChoose.get(x)){
            orderFulfillmentFix(border,materialType,qualified,suppliersNum,demand,copy,lower,upper,dq,de,cr,deliveryDate,tp,transportDate);
        }else {
            //计算满足要求的齐套率
            //将随机选择的供应商的订单量设置为刚好满足齐套要求
            int x_value = this.findFixedValue(x,materialType,qualified,demand,copy,dq,de,cr);
            //判断，如果此时满足齐套要求，则完成修复；否则在随机选择
            if (x_value <= upper.get(x)){
                copy.set(x,new IntegerAllele(x_value));
            }else {
                qualified = qualified + (int)Math.floor(upper.get(x) * (1 - dq.get(x) - de.get(x))) - (int)Math.floor(copy.get(x).getGene() * (1 - dq.get(x) - de.get(x)));
                copy.set(x,new IntegerAllele(upper.get(x)));
                //齐套需求修复方法
                orderFulfillmentFix(border,materialType,qualified,suppliersNum,demand,copy,lower,upper,dq,de,cr,deliveryDate,tp,transportDate);
            }
        }

    }

    //选择物料中供应商并修改其供应量，直至满足齐套率
    /**
     *
     * @param i 第i的供应商
     * @param materialType 物料类型
     * @param qualified 合格物料的总数量
     * @param demand 物料各自需求
     * @param copy 染色体基因数组
     * @param dq 次品率
     * @param de 延迟率
     * @param cr 齐套要求（%）[0,100]
     * @return 刚好满足齐套要求时，第i个供应商理论上的订单供应量
     */
    private int findFixedValue(int i, int materialType, int qualified, List<Integer> demand,
                               List<IntegerAllele> copy,List<Double> dq, List<Double> de, int cr){

        int x_qualified;

        double equals = (double) demand.get(materialType) * cr / 100.0;
        int target = (int)Math.floor(equals);
        if (target < equals){
            target = target + 1;
        }
        //x_qualified即为满足齐套需求时i供应商提供的合格品数量，x_v则对应i供应商订单量【即对应染色体上基因】
        x_qualified = target + (int)Math.floor(copy.get(i).getGene() * (1 - dq.get(i) - de.get(i))) - qualified;
        double x_value = x_qualified / (1 - dq.get(i) - de.get(i));
        int x_v;
        if (Math.floor(x_value) < x_value){
            x_v = (int)(Math.floor(x_value) + 1);
        }else {
            x_v = (int)x_value;
        }
        return x_v;

    }

}
