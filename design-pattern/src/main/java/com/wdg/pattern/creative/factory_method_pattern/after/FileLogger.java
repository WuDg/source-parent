package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 文件日志记录器
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class FileLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
