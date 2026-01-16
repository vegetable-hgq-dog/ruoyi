package custom.implementation.improved;

import com.debacharya.nsgaii.datastructure.Chromosome;
import java.util.ArrayList;
import java.util.List;

/**
 * 染色体去重工具类：基于Chromosome的identicalGeneticCode方法实现去重
 */
public class ChromosomeDuplicateRemover {

    /**
     * 对染色体列表去重（保留第一个出现的染色体，移除后续重复项）
     * @param chromosomes 待去重的染色体列表
     * @return 去重后的染色体列表
     */
    public static List<Chromosome> removeDuplicates(List<Chromosome> chromosomes) {
        List<Chromosome> uniqueChromosomes = new ArrayList<>();
        for (Chromosome chr : chromosomes) {
            boolean isDuplicate = false;
            // 遍历已保留的唯一染色体，判断是否重复
            for (Chromosome uniqueChr : uniqueChromosomes) {
                if (chr.identicalGeneticCode(uniqueChr)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueChromosomes.add(chr);
            }
        }
        return uniqueChromosomes;
    }

    /**
     * 去重后补充染色体至指定数量（若去重后数量不足，随机从原列表补充不重复的染色体）
     * @param originalList 原始染色体列表（用于补充）
     * @param targetSize 目标数量
     * @return 去重且数量满足要求的染色体列表
     */
    public static List<Chromosome> removeDuplicatesAndSupplement(List<Chromosome> originalList, int targetSize) {
        List<Chromosome> uniqueList = removeDuplicates(originalList);
        // 若去重后数量不足，从原始列表补充不重复的染色体
        if (uniqueList.size() < targetSize) {
            for (Chromosome chr : originalList) {
                if (uniqueList.size() >= targetSize) {
                    break;
                }
                boolean isDuplicate = false;
                for (Chromosome uniqueChr : uniqueList) {
                    if (chr.identicalGeneticCode(uniqueChr)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    uniqueList.add(chr);
                }
            }
        }
        // 若仍不足（极端情况），截断或重复补充（根据业务选择，此处截断）
        if (uniqueList.size() > targetSize) {
            return uniqueList.subList(0, targetSize);
        }
        return uniqueList;
    }
}