
package br.com.sss.Control;

//import javax.swing.JPanel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Diego Rangel
 */

public class GeraGrafico {
    /**
    Conexao co = new Conexao();
    
    public void criaGraficoAnual(JPanel painel, double valorJaneiro, double valorFevereiro, double valorMarco, double valorAbril, double valorMaio, double valorJunho, double valorJulho, double valorAgosto, double valorSetembro, double valorOutubro, double valorNovembro, double valorDezembro){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(valorJaneiro,"01/2017","Mês/Ano");
        dataset.addValue(valorFevereiro,"02/2017","Mês/Ano");
        dataset.addValue(valorMarco,"03/2017","Mês/Ano");
        dataset.addValue(valorAbril,"04/2017","Mês/Ano");
        dataset.addValue(valorMaio,"05/2017","Mês/Ano");
        dataset.addValue(valorJunho,"06/2017","Mês/Ano");
        dataset.addValue(valorJulho,"07/2017","Mês/Ano");
        dataset.addValue(valorAgosto,"08/2017","Mês/Ano");
        dataset.addValue(valorSetembro,"09/2017","Mês/Ano");
        dataset.addValue(valorOutubro,"10/2017","Mês/Ano");
        dataset.addValue(valorNovembro,"11/2017","Mês/Ano");
        dataset.addValue(valorDezembro,"12/2017","Mês/Ano");
        
        CategoryDataset cds = dataset;
        String titulo = "Gráfico";
        String eixoy = "Valores";
        String txt_legenda = "Ledenda:";

        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;

        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(painel.getWidth(),painel.getHeight());
        myChartPanel.setVisible(true);
        painel.removeAll();
        painel.add(myChartPanel);
        painel.revalidate();
        painel.repaint();
        
    }
    
    public void geraGraficoDeVendasMensal(JPanel Painel, String AnoAAAA){
        
        
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(co.retornaTotalDeVendasDoMes("01",AnoAAAA),"Jan/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("02",AnoAAAA),"Fev/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("03",AnoAAAA),"Mar/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("04",AnoAAAA),"Abr/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("05",AnoAAAA),"Mai/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("06",AnoAAAA),"Jun/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("07",AnoAAAA),"Jul/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("08",AnoAAAA),"Ago/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("09",AnoAAAA),"Set/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("10",AnoAAAA),"Out/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("11",AnoAAAA),"Nov/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeVendasDoMes("12",AnoAAAA),"Dez/17","Mês/Ano");
//        
//        CategoryDataset cds = dataset;
//        String titulo = "Gráfico";
//        String eixoy = "Valores";
//        String txt_legenda = "Ledenda:";
//
//        boolean legenda = true;
//        boolean tooltips = true;
//        boolean urls = true;
//
//        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
//        ChartPanel myChartPanel = new ChartPanel(graf, true);
//        myChartPanel.setSize(Painel.getWidth(),Painel.getHeight());
//        myChartPanel.setVisible(true);
//        Painel.removeAll();
//        Painel.add(myChartPanel);
//        Painel.revalidate();
//        Painel.repaint();
    }
    
    public void geraGraficoDeOSMensal(JPanel Painel){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(co.retornaTotalDeOSDoMes("01"),"Jan/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("02"),"Fev/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("03"),"Mar/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("04"),"Abr/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("05"),"Mai/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("06"),"Jun/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("07"),"Jul/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("08"),"Ago/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("09"),"Set/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("10"),"Out/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("11"),"Nov/17","Mês/Ano");
//        dataset.addValue(co.retornaTotalDeOSDoMes("12"),"Dez/17","Mês/Ano");
//        
//        CategoryDataset cds = dataset;
//        String titulo = "Gráfico";
//        String eixoy = "Valores";
//        String txt_legenda = "Ledenda:";
//
//        boolean legenda = true;
//        boolean tooltips = true;
//        boolean urls = true;
//
//        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
//        ChartPanel myChartPanel = new ChartPanel(graf, true);
//        myChartPanel.setSize(Painel.getWidth(),Painel.getHeight());
//        myChartPanel.setVisible(true);
//        Painel.removeAll();
//        Painel.add(myChartPanel);
//        Painel.revalidate();
//        Painel.repaint();
    }
    */
    
}
