package custom.implementation.constraint;

import com.debacharya.nsgaii.datastructure.AbstractAllele;
import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ConstraintFactor {

    /**
     * 是否满足需求约束
     * @param targetGene 需要判断的染色体基因数组
     * @param suppliersNum 该染色体中的基因有几种物料[即数组长度]，其对应有多少个可选择的供应商[即存入的多个整数]
     * @param demand 每种物料的需求量
     * @return 是否满足需求约束
     */
    public boolean satisfyDemand(List<IntegerAllele> targetGene, List<Integer> suppliersNum, List<Integer> demand){
        if (suppliersNum.size() == 0){
            throw new UnsupportedOperationException("at least one gene");
        }
//        List<IntegerAllele> copy = new ArrayList<>();
//        for (int i = 0; i < chromosome.getLength(); i++){
//            copy.add(i,(IntegerAllele) chromosome.getGeneticCode().get(i).getCopy());
//        }
        //判断供应商数量和染色体基因数量是否相同，不同则表示有误
        int totalSuppliersNums = 0;
        for (int j = 0; j < suppliersNum.size(); j++){
            totalSuppliersNums += suppliersNum.get(j);
        }
        if (targetGene.size() != totalSuppliersNums){
            throw new UnsupportedOperationException("Incorrect supplier quantity");
        }

        //判断不同物料需求
        //materialType为物料种类，sum为某种物料总供应，count标记目前正在计算哪个供应商情况，border标记哪类物料已经判断完成{为某种物料最后供应商的序号}
        int materialType = 0;
        int sum = 0;
        int count = 0;
        int border = 0;
        while(materialType < suppliersNum.size()){
            if (count < suppliersNum.get(materialType) + border && count < targetGene.size()){
                sum += targetGene.get(count++).getGene();
            }else {
                if (sum < demand.get(materialType)){
                    return false;
                }else {
                    border += suppliersNum.get(materialType);
                    sum = 0;
                    materialType++;
                }
            }
        }

        return true;
    }

    /**
     * 判断是否满足交期
     * @param targetGene 需要判断的染色体基因数组
     * @param suppliersNum 该染色体中的基因有几种物料[即数组长度]，其对应有多少个可选择的供应商[即存入的多个整数]
     * @param demand 每种物料的需求量
     * @param dq 次品率
     * @param de 延期率
     * @param cr 齐套要求（%）
     * @return 是否满足齐套约束
     */
    public boolean satisfyOrderFulfillment(List<IntegerAllele> targetGene, List<Integer> suppliersNum, List<Integer> demand, List<Double> dq, List<Double> de, int cr){

        //判断不同物料需求
        //materialType为物料种类，qualified为合格数量，count标记目前正在计算哪个供应商情况，border标记哪类物料已经判断完成{为某种物料最后供应商的序号}
        int materialType = 0;
        int qualified = 0;
        int count = 0;
        int border = 0;
        while(materialType < suppliersNum.size()){
            if (count < suppliersNum.get(materialType) + border && count < targetGene.size()){
                qualified += (int)Math.floor(targetGene.get(count).getGene() * (1 - dq.get(count) - de.get(count)));
                count++;
            }else {
                if (qualified / (double)demand.get(materialType) < cr/100.0){
                    return false;
                }else {
                    border += suppliersNum.get(materialType);
                    qualified = 0;
                    materialType++;
                }
            }
        }
        return true;
    }

    /**
     * 根据交期约束，判断全部供应商选择情况；不满足情况的y设置为0，其余为1（供应商订单量==0相当于未被选择，此时xy==0，所以无需考虑）
     * @param deliveryDate 订单交期，单位（天），可以为3.6天等
     * @param tp 某供应商生产1单位对应物料想要的天数（例如：1/500天/个）
     * @param transportDate 该供应商给目标企业供应需要的运输时间
     * @param lower 订单起订量
     * @return 是否选择供应商
     */
    public List<Boolean> suppliersChoose(double deliveryDate, List<Double> tp, List<Double> transportDate, List<Integer> lower){

        if (tp.size() != transportDate.size() || transportDate.size() != lower.size()){
            throw new UnsupportedOperationException("The production capacity and shipping time of all suppliers are not given");
        }

        List<Boolean> orders = new ArrayList<>();
        for (int i = 0; i < lower.size(); i++){
            int maxOrder = (int)Math.floor((deliveryDate - transportDate.get(i)) / tp.get(i));
            if (maxOrder < lower.get(i)){
                orders.add(i,false);
            }else {
                orders.add(i,true);
            }
        }
        return orders;
    }

    /**
     *
     * @param deliveryDate 订单交期，单位（天），可以为3.6天等
     * @param tp 某供应商生产1单位对应物料想要的天数（例如：1/500天/个）
     * @param transportDate 该供应商给目标企业供应需要的运输时间
     * @param upper 最大订单供应量
     * @return 满足订单齐套约束下的最大订单供应量
     */
    public List<Integer> getUpperOrder(double deliveryDate, List<Double> tp, List<Double> transportDate, List<Integer> upper){

        if (tp.size() != transportDate.size() || transportDate.size() != upper.size()){
            throw new UnsupportedOperationException("The production capacity and shipping time of all suppliers are not given");
        }

        List<Integer> maxOrders = new ArrayList<>();
        for (int i = 0; i < upper.size(); i++){
            int maxOrder = (int)Math.floor((deliveryDate - transportDate.get(i)) / tp.get(i));
            if (maxOrder < upper.get(i)){
                maxOrders.add(i,maxOrder);
            }else {
                maxOrders.add(i, upper.get(i));
            }
        }
        return maxOrders;
    }
}
