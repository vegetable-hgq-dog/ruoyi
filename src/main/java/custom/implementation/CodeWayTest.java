package custom.implementation;

import com.debacharya.nsgaii.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CodeWayTest {

    public List<Integer> test(int length, List<Integer> suppliersNum, List<Integer> demand, List<Integer> lower, List<Integer> upper){
        int suppliers = 0;
        int count = 0;
        //totalNum记录编码生成到哪一类零部件供应商了
        int totalNum = 0;
        int sum = 0;
        List<Integer> geneticCode = new ArrayList<>();

        //length的长度为suppliersNum中供应商数量和
        while (suppliers < suppliersNum.size()){

            //判断染色体在为第i类物料的编码生成
            if (count < suppliersNum.get(suppliers) + totalNum && count < length){
                int value = ThreadLocalRandom.current().nextInt(lower.get(count),upper.get(count)+1);
                sum += value;
                //是否第一次编码，第一次生成编码使用add，否则set
                if (geneticCode.size() == count){
                    geneticCode.add(
                            count++,
                            value
                    );
                }else {
                    geneticCode.set(
                            count++,
                            value
                    );
                }
            }else {
                //如果不能满足需求，则重新生成这一段编码
                if (sum < demand.get(suppliers)){
                    count = count - suppliersNum.get(suppliers);
                    sum = 0;
                }else {
                    totalNum = suppliersNum.get(suppliers);
                    sum = 0;
                    suppliers++;
                }
            }
        }
        return geneticCode;
    }


}
