package com.wdg.pattern.creative.simple_factory_pattern.common;

/**
 *  @Description 客户端测试
 *
 *  @author wudiguang
 *  @Date 2021/11/28
 */
public class Client {
    public static void main(String[] args) {
        IChartService chart = ChartFactory.getChart("pie");
        chart.display();;
    }
}
