package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 日志记录器工厂接口：抽象工厂
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public interface LoggerFactory {
    /*创建抽象日志记录器*/
    Logger createLogger();
}
