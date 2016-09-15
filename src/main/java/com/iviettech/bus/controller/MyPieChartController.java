package com.iviettech.bus.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/charts")
public class MyPieChartController {
    @RequestMapping(value = "/piechart",method = RequestMethod.GET)
    public void drawPieChart(HttpServletResponse response){
        response.setContentType("image/png");
        PieDataset pdSet=createDataSet();
        JFreeChart chart=createChart(pdSet,"Th?ng kê s? l??ng xe c?a các hãng");
        try{
            ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart,750,400);
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JFreeChart createChart(PieDataset pdSet,String chartTitle) {
        JFreeChart chart= ChartFactory.createPieChart3D(chartTitle, pdSet, true, true, false);
        PiePlot3D plot= (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }

    private PieDataset createDataSet() {
        DefaultPieDataset dpd=new DefaultPieDataset();
        dpd.setValue("Ph??ng Trang",3);
        dpd.setValue("Hoàng Long",2);
        dpd.setValue("Mai Linh",1);
        return dpd;
    }
}
