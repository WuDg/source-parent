package com.wdg.pattern.creative.simple_factory_pattern.common;

import java.util.Objects;

/**
 *  @Description 图表工厂类：工厂类
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class ChartFactory {
    /*静态工厂方法*/
    public static IChartService getChart(String type){
        IChartService chart = null;
        if(Objects.equals("histogram", type)){
            // 初始柱饼状图
            chart = new HistogramChartServiceImpl();
        }else if(Objects.equals("pie", type)){
            // 初始化饼状图
            chart = new PieChartServiceImpl();
        }else if(Objects.equals("line", type)){
            // 初始化折线图
            chart = new LineChartServiceImpl();
        }
        return chart;
    }
}
