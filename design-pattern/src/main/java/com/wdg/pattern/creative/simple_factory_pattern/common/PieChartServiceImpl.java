package com.wdg.pattern.creative.simple_factory_pattern.common;

/**
 *  @Description 饼状图：具体产品类
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class PieChartServiceImpl implements IChartService{
    public PieChartServiceImpl() {
        System.out.println("创建饼状图~");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图~");
    }
}
