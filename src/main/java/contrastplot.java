import org.jfree.data.xy.XYSeries;
import custom.implementation.comparison.PerformancePlot;

public class contrastplot {
    public static void main(String[] args) {
        // ==================== 第一个图表：场景1（基础性能对比） ====================
        XYSeries series1_1 = new XYSeries("算法A-场景1");
        series1_1.add(10, 50);
        series1_1.add(20, 80);
        series1_1.add(30, 120);

        XYSeries series1_2 = new XYSeries("算法B-场景1");
        series1_2.add(10, 60);
        series1_2.add(20, 90);
        series1_2.add(30, 110);

        // 生成第一个图表窗口
        new PerformancePlot(series1_1, series1_2, "算法性能对比-场景1", "数据量", "执行时间(ms)");

        // ==================== 第二个图表：场景2（大数据量对比） ====================
        XYSeries series2_1 = new XYSeries("算法A-场景2");
        series2_1.add(50, 200);
        series2_1.add(100, 450);
        series2_1.add(150, 700);

        XYSeries series2_2 = new XYSeries("算法B-场景2");
        series2_2.add(50, 180);
        series2_2.add(100, 400);
        series2_2.add(150, 650);

        // 生成第二个图表窗口
        new PerformancePlot(series2_1, series2_2, "算法性能对比-场景2", "大数据量", "执行时间(ms)");

        // ==================== 第三个图表：场景3（响应速度对比） ====================
        XYSeries series3_1 = new XYSeries("算法A-场景3");
        series3_1.add(1, 8);
        series3_1.add(2, 15);
        series3_1.add(3, 22);

        XYSeries series3_2 = new XYSeries("算法B-场景3");
        series3_2.add(1, 6);
        series3_2.add(2, 12);
        series3_2.add(3, 18);

        // 生成第三个图表窗口
        new PerformancePlot(series3_1, series3_2, "算法性能对比-场景3", "请求数", "响应时间(ms)");
    }
}