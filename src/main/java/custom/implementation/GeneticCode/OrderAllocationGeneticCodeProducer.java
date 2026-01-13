package custom.implementation.GeneticCode;

import com.debacharya.nsgaii.datastructure.AbstractAllele;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.plugin.GeneticCodeProducer;
import custom.implementation.constraint.ConstraintFactor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OrderAllocationGeneticCodeProducer {

    //suppliersNum输入的是各类别供应商数量,demand为各类别零件总需求
    //输入的lower和upper为每个供应商其可以接受订单的上下限，数组具体长度由染色体长度[length]确定（染色体长度也即为供应商数量）
    //按照顺序生成一定范围内的整数编码值

    //约束条件在此设置，后期交叉、变异时候也应该满足约束条件
    public static GeneticCodeProducer orderAllocationGeneProducer(List<Integer> suppliersNum, List<Integer> demand, List<Integer> lower, List<Integer> upper,
                                                                  List<Double> dq, List<Double> de, int cr, double deliveryDate, List<Double> tp, List<Double> transportDate)
    {
        return length -> {
            //为设置全部供应商可分配订单的范围时报错
            if (lower.size() != length || upper.size() != length){
                throw new UnsupportedOperationException("The range of the order-allocation is not fully set");
            }
            if (suppliersNum.size() != demand.size()){
                throw new UnsupportedOperationException("The length of the array does not correspond, the type and demand of the parts supplier should correspond one by one");
            }
            //suppliers即materialType
            int suppliers = 0;
            int count = 0;
            //totalNum记录编码生成到哪一类零部件供应商了,border
            int totalNum = 0;
            int sum = 0;
            int qualified = 0;
            List<IntegerAllele> geneticCode = new ArrayList<>();
            List<Boolean> suppliersChoose = new ConstraintFactor().suppliersChoose(deliveryDate, tp, transportDate, lower);
            List<Integer> upperOrder = new ConstraintFactor().getUpperOrder(deliveryDate, tp, transportDate, upper);

            //length的长度为suppliersNum中供应商数量和
            while (suppliers < suppliersNum.size()){

                //判断染色体在为第i类物料的编码生成
                if (count < suppliersNum.get(suppliers) + totalNum && count < length){
                    int value;
                    if (suppliersChoose.get(count)){
                        value = orderGenerate(count,lower,upperOrder);
                    }else {
                        value = 0;
                    }
                    qualified += (int)Math.floor(value * (1 - dq.get(count) - de.get(count)));
                    sum += value;
                    //是否第一次编码，第一次生成编码使用add，否则set
                    if (geneticCode.size() == count){
                        geneticCode.add(
                                count++,
                                new IntegerAllele(value)
                        );
                    }else {
                        geneticCode.set(
                                count++,
                                new IntegerAllele(value)
                        );
                    }
                } else {
                    //如果不能满足需求，则重新生成这一段编码，这里不需要使用修复机制
                    if (sum < demand.get(suppliers) || qualified / (double)demand.get(suppliers) < cr/100.0){
                        count = count - suppliersNum.get(suppliers);
                        sum = 0;
                    }else {
                        totalNum += suppliersNum.get(suppliers);
                        sum = 0;
                        suppliers++;
                    }
                }

            }
            return geneticCode;
        };
    }

    //随机生成供应商订单量[min,max]及0（表示不选择供应商）
    public static int orderGenerate(int i, List<Integer> lower, List<Integer> upper){
        if (lower.get(i) == 0){
            return ThreadLocalRandom.current().nextInt(0,upper.get(i) + 1);
        }else {
            //例：将订单范围0，[3,6]变为[0，4]
            int orderNumber = ThreadLocalRandom.current().nextInt(0,upper.get(i) - lower.get(i) + 2);
            if (orderNumber != 0) {
                if (orderNumber + lower.get(i) - 1 >= lower.get(i)) {
                    return orderNumber + lower.get(i) - 1;
                }
            }
            return 0;
        }
    }
}