package custom.implementation.comparison;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class PerformancePlot extends ApplicationFrame {
    private static final String Title = "algorithm performance";
    private int dimensionX = 800;
    private int dimensionY = 600;

    public PerformancePlot(XYSeries series1, XYSeries series2, String title, String xAxisLabel, String yAxisLabel) {
        super(PerformancePlot.Title);
        initUI(series1, series2, title, xAxisLabel, yAxisLabel);
    }

    public void initUI(XYSeries series1, XYSeries series2, String title, String xAxisLabel, String yAxisLabel){
        XYDataset dataset = createDataset(series1, series2);
        JFreeChart chart = createChart(dataset, title, xAxisLabel, yAxisLabel);
        ChartPanel chartPanel = new ChartPanel(chart);
        Font font = chart.getLegend().getItemFont().deriveFont(24f);
        chart.getLegend().setItemFont(font);
        chart.fireChartChanged(); // 更新图表
        chartPanel.setPreferredSize(
                new java.awt.Dimension(
                        this.dimensionX,
                        this.dimensionY
                )
        );
        setContentPane(chartPanel);

        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
    private XYDataset createDataset(XYSeries series1, XYSeries series2) {

//        XYSeries series1 = new XYSeries("2014");
//        series1.add(18, 530);
//        series1.add(20, 580);
//        series1.add(25, 740);
//        series1.add(30, 901);
//        series1.add(40, 1300);
//        series1.add(50, 2219);
//
//        XYSeries series2 = new XYSeries("2016");
//        series2.add(18, 567);
//        series2.add(20, 612);
//        series2.add(25, 800);
//        series2.add(30, 980);
//        series2.add(40, 1210);
//        series2.add(50, 2350);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset, String title, String xAxisLabel, String yAxisLabel) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        //背景色
//        plot.setBackgroundPaint(Color.white);
        //网格是否开启
//        plot.setRangeGridlinesVisible(false);
//        plot.setDomainGridlinesVisible(false);

//        chart.getLegend().setFrame(BlockBorder.NONE);
//
//        chart.setTitle(new TextTitle("Average Salary per Age",
//                        new Font("Serif", Font.BOLD, 18)
//                )
//        );

        return chart;
    }


}
