package com.wdg.pattern.creative.simple_factory_pattern.simple;


/**
 *  @Description 柱状图：具体产品类
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class HistogramChartServiceImpl extends AbstractChart {
    public HistogramChartServiceImpl() {
        System.out.println("创建柱状图~");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图~");
    }
}
