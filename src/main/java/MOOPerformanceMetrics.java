import java.util.*;

/**
 * 双目标优化问题的NSGA-II性能指标计算工具
 * 目标1：最小化生产成本；目标2：最小化不合格品及未按期交付产品总数
 */
public class MOOPerformanceMetrics {

    // 定义解的结构：存储两个目标值
    static class Solution {
        double cost; // 目标1：生产成本（越小越好）
        double defect; // 目标2：不合格品及未按期交付数（越小越好）

        public Solution(double cost, double defect) {
            this.cost = cost;
            this.defect = defect;
        }

        // 判断当前解是否支配另一个解（双目标最小化）
        public boolean dominates(Solution other) {
            // 支配条件：所有目标≤对方，且至少一个目标<对方
            boolean allBetterOrEqual = (this.cost <= other.cost) && (this.defect <= other.defect);
            boolean atLeastOneBetter = (this.cost < other.cost) || (this.defect < other.defect);
            return allBetterOrEqual && atLeastOneBetter;
        }

        // 计算两个解之间的欧几里得距离
        public double euclideanDistance(Solution other) {
            double dx = this.cost - other.cost;
            double dy = this.defect - other.defect;
            return Math.sqrt(dx * dx + dy * dy);
        }

        @Override
        public String toString() {
            return String.format("[%.1f, %.1f]", cost, defect);
        }
    }

    public static void main(String[] args) {
        // ===================== 1. 定义两个测试解集（替换为你的实际数据）=====================
        // 解集A（例如：NSGA-II的帕累托前沿）
        List<Solution> solutionSetA = new ArrayList<>();
        solutionSetA.add(new Solution(836942.0, 364.0));
        solutionSetA.add(new Solution(850000.0, 350.0));
        solutionSetA.add(new Solution(820000.0, 370.0));
        solutionSetA.add(new Solution(840000.0, 360.0));

        // 解集B（例如：改进版NSGA-II_RM的帕累托前沿）
        List<Solution> solutionSetB = new ArrayList<>();
        solutionSetB.add(new Solution(830000.0, 365.0));
        solutionSetB.add(new Solution(845000.0, 355.0));
        solutionSetB.add(new Solution(825000.0, 368.0));

        // ===================== 2. 计算三个核心指标 =====================
        // 2.1 覆盖率指标 CM(C(A,B), C(B,A))
        double[] cmValues = calculateCM(solutionSetA, solutionSetB);
        // 2.2 合并解集用于计算全局极值（DM/HV需要）
        List<Solution> allSolutions = new ArrayList<>();
        allSolutions.addAll(solutionSetA);
        allSolutions.addAll(solutionSetB);
        // 2.3 超体积指标 HV
        double hvA = calculateHV(solutionSetA, allSolutions);
        double hvB = calculateHV(solutionSetB, allSolutions);
        // 2.4 多样性度量 DM
        double dmA = calculateDM(solutionSetA, allSolutions);
        double dmB = calculateDM(solutionSetB, allSolutions);

        // ===================== 3. 打印结果 =====================
        System.out.println("======= 多目标优化性能指标计算结果 =======");
        System.out.println("1. 覆盖率指标（CM）：");
        System.out.println("   C(A,B) = " + String.format("%.4f", cmValues[0]) + " （B中被A支配的解比例）");
        System.out.println("   C(B,A) = " + String.format("%.4f", cmValues[1]) + " （A中被B支配的解比例）");
        System.out.println("2. 超体积指标（HV）：");
        System.out.println("   解集A的HV值 = " + String.format("%.2f", hvA));
        System.out.println("   解集B的HV值 = " + String.format("%.2f", hvB));
        System.out.println("3. 多样性度量（DM）：");
        System.out.println("   解集A的DM值 = " + String.format("%.4f", dmA));
        System.out.println("   解集B的DM值 = " + String.format("%.4f", dmB));
    }

    /**
     * 计算覆盖率指标 CM(C(A,B), C(B,A))
     * @param setA 解集A
     * @param setB 解集B
     * @return double[0] = C(A,B)（B被A支配的比例）; double[1] = C(B,A)（A被B支配的比例）
     */
    public static double[] calculateCM(List<Solution> setA, List<Solution> setB) {
        // 统计B中被A支配的解数量
        int dominatedByA = 0;
        for (Solution b : setB) {
            boolean isDominated = false;
            for (Solution a : setA) {
                if (a.dominates(b)) {
                    isDominated = true;
                    break;
                }
            }
            if (isDominated) {
                dominatedByA++;
            }
        }

        // 统计A中被B支配的解数量
        int dominatedByB = 0;
        for (Solution a : setA) {
            boolean isDominated = false;
            for (Solution b : setB) {
                if (b.dominates(a)) {
                    isDominated = true;
                    break;
                }
            }
            if (isDominated) {
                dominatedByB++;
            }
        }

        // 计算覆盖率（避免除以0）
        double cAB = setB.isEmpty() ? 0 : (double) dominatedByA / setB.size();
        double cBA = setA.isEmpty() ? 0 : (double) dominatedByB / setA.size();

        return new double[]{cAB, cBA};
    }

    /**
     * 计算超体积指标 HV（双目标最小化）
     * @param targetSet 待计算的解集
     * @param allSolutions 所有解集（用于计算参考点）
     * @return HV值（越大越好）
     */
    public static double calculateHV(List<Solution> targetSet, List<Solution> allSolutions) {
        if (targetSet.isEmpty()) return 0.0;

        // 步骤1：自动计算参考点（所有目标值的最大值 ×1.1）
        double maxCost = allSolutions.stream().mapToDouble(s -> s.cost).max().orElse(1.0);
        double maxDefect = allSolutions.stream().mapToDouble(s -> s.defect).max().orElse(1.0);
        double refCost = maxCost * 1.1;
        double refDefect = maxDefect * 1.1;
        Solution referencePoint = new Solution(refCost, refDefect);

        // 步骤2：按目标1（成本）升序排序解集（保证计算面积时不重复）
        List<Solution> sortedSet = new ArrayList<>(targetSet);
        sortedSet.sort(Comparator.comparingDouble(s -> s.cost));

        // 步骤3：计算超体积（二维矩形面积累加）
        double hv = 0.0;
        for (int i = 0; i < sortedSet.size(); i++) {
            Solution s = sortedSet.get(i);
            if (i == 0) {
                // 第一个解：参考点到该解的矩形面积
                hv += Math.abs(s.cost - referencePoint.cost) * Math.abs(s.defect - referencePoint.defect);
            } else {
                // 后续解：层叠面积（避免重复计算）
                Solution prev = sortedSet.get(i - 1);
                hv += Math.abs(s.cost - referencePoint.cost) * Math.abs(s.defect - prev.defect);
            }
        }

        return hv;
    }

    /**
     * 计算多样性度量 DM（值越小越好）
     * @param targetSet 待计算的解集
     * @param allSolutions 所有解集（用于找全局边界解）
     * @return DM值
     */
    public static double calculateDM(List<Solution> targetSet, List<Solution> allSolutions) {
        if (targetSet.size() < 2) return 1.0; // 解数量不足时返回最大值

        // 步骤1：找全局边界解和当前解集的极端解
        // 全局下边界解（成本最小）、全局上边界解（成本最大）
        Solution globalMinCost = allSolutions.stream().min(Comparator.comparingDouble(s -> s.cost)).orElse(null);
        Solution globalMaxCost = allSolutions.stream().max(Comparator.comparingDouble(s -> s.cost)).orElse(null);
        // 当前解集的下极端解（成本最小）、上极端解（成本最大）
        Solution localMinCost = targetSet.stream().min(Comparator.comparingDouble(s -> s.cost)).orElse(null);
        Solution localMaxCost = targetSet.stream().max(Comparator.comparingDouble(s -> s.cost)).orElse(null);

        // 步骤2：计算df（下边界-下极端）、dl（上边界-上极端）的欧氏距离
        double df = globalMinCost.euclideanDistance(localMinCost);
        double dl = globalMaxCost.euclideanDistance(localMaxCost);

        // 步骤3：按成本排序当前解集，计算相邻解的欧氏距离di
        List<Solution> sortedSet = new ArrayList<>(targetSet);
        sortedSet.sort(Comparator.comparingDouble(s -> s.cost));
        double sumDi = 0.0;
        int n = sortedSet.size() - 1;
        for (int i = 0; i < n; i++) {
            sumDi += sortedSet.get(i).euclideanDistance(sortedSet.get(i + 1));
        }
        double avgDi = sumDi / n; // di的平均值

        // 步骤4：计算所有di与avgDi的绝对偏差和
        double sumAbsDeviation = 0.0;
        for (int i = 0; i < n; i++) {
            double di = sortedSet.get(i).euclideanDistance(sortedSet.get(i + 1));
            sumAbsDeviation += Math.abs(di - avgDi);
        }

        // 步骤5：计算DM值（归一化）
        double numerator = df + dl + sumAbsDeviation;
        double denominator = df + dl + n * avgDi;
        return denominator == 0 ? 0 : numerator / denominator;
    }
}