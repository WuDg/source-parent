package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 数据库日志记录器
 *  
 *  @author wudiguang
 *  @Date 2021/12/2
 */ 
public class DatabaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
