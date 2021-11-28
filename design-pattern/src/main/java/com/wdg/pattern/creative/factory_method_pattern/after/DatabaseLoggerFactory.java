package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 数据库日志记录器工厂类：具体工厂
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        // 连接数据库
        // 创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        // 初始化数据库日志记录器，略
        return logger;
    }
}
