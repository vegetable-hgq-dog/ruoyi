package custom.implementation.GeneticCode;

import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.plugin.GeneticCodeProducer;
import custom.implementation.constraint.ConstraintFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CodeProducerWithoutSet {

    public static GeneticCodeProducer originalGeneCodeProducer(List<Integer> suppliersNum, List<Integer> demand, List<Integer> lower, List<Integer> upper)
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

            //length的长度为suppliersNum中供应商数量和
            while (suppliers < suppliersNum.size()){

                //判断染色体在为第i类物料的编码生成
                if (count < suppliersNum.get(suppliers) + totalNum && count < length){
                    int value = orderGenerate(count,lower,upper);
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
                    if (sum < demand.get(suppliers)){
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
            if (orderNumber == 0){
                return 0;
            }else {
                return orderNumber + lower.get(i) - 1;
            }
        }
    }

}
