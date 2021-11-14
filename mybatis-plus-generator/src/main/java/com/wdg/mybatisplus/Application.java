package com.wdg.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *  @Description 启动类
 *  
 *  @author wudiguang
 *  @Date 2021/11/14
 */ 

@SpringBootApplication
@MapperScan(basePackages = {"com.wdg.mybatisplus.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
