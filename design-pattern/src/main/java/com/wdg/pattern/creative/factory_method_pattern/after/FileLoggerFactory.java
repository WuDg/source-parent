package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 文件日志记录器工厂类：具体工厂
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        // 连接日志文件
        // 创建文件日志记录器对象
        Logger logger = new FileLogger();
        // 初始化文件日志记录器，略
        return logger;
    }
}
