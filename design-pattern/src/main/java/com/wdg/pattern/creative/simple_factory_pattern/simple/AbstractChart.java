package com.wdg.pattern.creative.simple_factory_pattern.simple;

import java.util.Objects;

/**
 *  @Description 抽象图表接口：抽象产品类
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public abstract class AbstractChart {
    /*显示*/
    abstract void display();

    /*静态工厂方法*/
    public static AbstractChart getChart(String type){
        AbstractChart chart = null;
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
