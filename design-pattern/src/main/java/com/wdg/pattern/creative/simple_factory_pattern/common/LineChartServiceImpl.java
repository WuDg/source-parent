package com.wdg.pattern.creative.simple_factory_pattern.common;

/**
 *  @Description 折线图：具体产品类
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class LineChartServiceImpl implements IChartService{
    public LineChartServiceImpl() {
        System.out.println("创建折线图~");
    }

    @Override
    public void display() {
        System.out.println("显示折线图~");
    }
}
