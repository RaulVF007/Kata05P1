package kata05p1;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack(); //Con este método la ventana se ajusta y responde a todas las interacciones de redimensión de tamaño
        
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram",
                "Email domains", "Nº emails",
                dataset, PlotOrientation.VERTICAL, false, 
                false, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int other  = 0; 
        for (String key : histogram.keySet()) {
            if(histogram.get(key)== 1) 
                other++; 
            else 
                dataset.addValue(histogram.get(key), "", key);//nuevo
        }
        dataset.addValue(other, "", "Others"); 
        return dataset;
    }
    
    public void execute(){
        this.setVisible(true);
    }    
}