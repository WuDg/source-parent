package com.wdg.pattern.creative.simple_factory_pattern;

import java.util.Objects;

/**
 *  @Description 图表
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class SourceChart {
    /*图表类型*/
    private String type;

    /*根据不同type初始化不同的图表*/
    public SourceChart(Object[][] data, String type){
        this.type = type;
        if(Objects.equals("histogram", type)){
            // 初始化饼状图
        }else if(Objects.equals("pie", type)){
            // 初始化饼状图
        }else if(Objects.equals("line", type)){
            // 初始化折线图
        }
    }

    /*显示*/
    public void display(){
        if(Objects.equals("histogram", this.type)){
            // 显示饼状图
        }else if(Objects.equals("pie", this.type)){
            // 显示饼状图
        }else if(Objects.equals("line", this.type)){
            // 显示折线图
        }
    }
}
