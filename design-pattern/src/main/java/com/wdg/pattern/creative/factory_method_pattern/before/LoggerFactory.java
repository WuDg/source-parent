package com.wdg.pattern.creative.factory_method_pattern.before;

import java.util.Objects;

/**
 *  @Description 日志记录器工厂
 *  
 *  @author wudiguang
 *  @Date 2021/11/28
 */ 
public class LoggerFactory {
    /*静态工厂方法*/
    public static Logger createLogger(String type){
        if(Objects.equals("db", type)){
            // 连接数据库
            // 创建数据库日志记录器对象
            Logger logger = new DatabaseLogger();
            // 初始化数据库日志记录器，略
            return logger;
        }else if(Objects.equals("file", type)){
            // 连接日志文件
            // 创建文件日志记录器对象
            Logger logger = new FileLogger();
            // 初始化文件日志记录器，略
            return logger;
        }
        return null;
    }

    /*抽象日志类*/
    interface Logger{

    }
    /*数据库日志记录器*/
    public static class DatabaseLogger implements Logger{

    }
    /*文件日志记录器*/
    public static class FileLogger implements Logger{

    }
}
