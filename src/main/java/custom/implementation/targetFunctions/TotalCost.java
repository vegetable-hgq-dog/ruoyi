package custom.implementation.targetFunctions;

import com.debacharya.nsgaii.datastructure.Chromosome;
import com.debacharya.nsgaii.datastructure.IntegerAllele;
import com.debacharya.nsgaii.objectivefunction.AbstractObjectiveFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 总成本计算目标函数
 * 优化点：1. 提取魔法值为常量 2. 补充空指针/除零校验 3. 简化冗余集合操作 4. 优化循环逻辑 5. 兼容Java 8（移除List.of()）
 */
public class TotalCost extends AbstractObjectiveFunction {

    // 提取魔法值为常量，增加可读性和维护性
    private static final int COST_PER_UNIT_LOSS = 300; // 少生产1台的损失成本（元）
    private static final int TARGET_PRODUCTION = 900; // 空调需求产量Qt
    private static final String OBJECTIVE_TITLE = "cost";

    private final List<Integer> suppliersNum;
    private final List<Integer> demand;
    private final List<Double> dq;
    private final List<Double> de;

    // 购买成本数组（按供应商顺序）- Java 8兼容写法
    private static final List<Double> PURCHASE_COST;
    // 运输成本数组（按供应商顺序）- Java 8兼容写法
    private static final List<Double> TRANSPORT_COST;

    // 静态代码块初始化成本列表（Java 8及以下兼容）
    static {
        PURCHASE_COST = new ArrayList<>();
        PURCHASE_COST.add(460.0);
        PURCHASE_COST.add(325.0);
        PURCHASE_COST.add(51.0);
        PURCHASE_COST.add(45.0);
        PURCHASE_COST.add(38.0);
        PURCHASE_COST.add(32.0);
        PURCHASE_COST.add(53.0);
        PURCHASE_COST.add(400.0);
        PURCHASE_COST.add(286.0);
        PURCHASE_COST.add(335.0);

        TRANSPORT_COST = new ArrayList<>();
        TRANSPORT_COST.add(20.0);
        TRANSPORT_COST.add(35.0);
        TRANSPORT_COST.add(2.0);
        TRANSPORT_COST.add(3.0);
        TRANSPORT_COST.add(6.0);
        TRANSPORT_COST.add(2.0);
        TRANSPORT_COST.add(5.0);
        TRANSPORT_COST.add(15.0);
        TRANSPORT_COST.add(30.0);
        TRANSPORT_COST.add(25.0);
    }

    /**
     * 构造函数：补充空指针校验，快速失败
     */
    public TotalCost(List<Integer> suppliersNum, List<Integer> demand,
                     List<Double> dq, List<Double> de) {
        // 空指针校验
        if (suppliersNum == null || demand == null || dq == null || de == null) {
            throw new IllegalArgumentException("入参不可为null：suppliersNum/demand/dq/de");
        }
        // 长度一致性校验
        if (suppliersNum.size() != demand.size()) {
            throw new IllegalArgumentException("suppliersNum长度与demand长度必须一致");
        }

        this.objectiveFunctionTitle = OBJECTIVE_TITLE;
        this.suppliersNum = suppliersNum;
        this.demand = demand;
        this.dq = dq;
        this.de = de;
    }

    @Override
    public double getValue(Chromosome chromosome) {
        // 空指针校验
        if (chromosome == null || chromosome.getGeneticCode() == null) {
            throw new IllegalArgumentException("Chromosome不可为null或geneticCode为空");
        }

        // 转换基因编码（提前校验类型，避免循环内强制转换）
        List<IntegerAllele> geneticCode = chromosome.getGeneticCode().stream()
                .filter(allele -> allele instanceof IntegerAllele)
                .map(allele -> (IntegerAllele) allele)
                .collect(Collectors.toList());

        // 提前校验基因编码长度，避免循环内重复判断
        int geneticCodeSize = geneticCode.size();
        if (geneticCodeSize == 0) {
            return 0.0; // 无基因编码时成本为0
        }

        // 简化Ft为单个变量（原逻辑仅用第一个元素，无需集合）
        double ft = 1.0; // 齐套程度，初始值1.0
        int materialType = 0;
        int qualified = 0;
        int count = 0;
        int border = 0;
        double totalPurchaseCost = 0.0; // 总购买成本（替换原xyb，用double避免整型溢出）
        double totalTransportCost = 0.0; // 总运输成本（替换原xyf，用double避免整型溢出）

        // 循环优化：减少冗余判断，简化逻辑
        while (materialType < suppliersNum.size()) {
            int currentSupplierCount = suppliersNum.get(materialType);
            int currentBorder = border + currentSupplierCount;

            // 处理当前物料类型的所有供应商
            while (count < currentBorder && count < geneticCodeSize) {
                int geneValue = geneticCode.get(count).getGene();
                // 计算合格数量（向下取整）
                double defectRate = dq.get(count) + de.get(count);
                qualified += (int) Math.floor(geneValue * (1 - defectRate));

                // 累计成本（避免整型溢出，直接用double计算）
                totalPurchaseCost += PURCHASE_COST.get(count) * geneValue;
                totalTransportCost += TRANSPORT_COST.get(count) * geneValue;

                count++;
            }

            // 计算齐套率，补充除零校验
            int currentDemand = demand.get(materialType);
            double cr = currentDemand == 0 ? 0.0 : (double) qualified / currentDemand;
            if (cr <= ft) {
                ft = cr;
            }

            // 重置状态，处理下一个物料类型
            border = currentBorder;
            qualified = 0;
            materialType++;
        }

        // 计算未完成产能的损失成本
        double lossCost = COST_PER_UNIT_LOSS * (1 - ft) * TARGET_PRODUCTION;
        // 总成本 = 损失成本 + 购买成本 + 运输成本
        return lossCost + totalPurchaseCost + totalTransportCost;
    }
}