package com.wdg.pattern.creative.factory_method_pattern.after;

/**
 *  @Description 客户端测试
 *
 *  @author wudiguang
 *  @Date 2021/11/28
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger();
        logger.writeLog();
    }
}
