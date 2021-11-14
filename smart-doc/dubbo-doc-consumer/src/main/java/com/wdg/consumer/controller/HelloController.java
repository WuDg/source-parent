package com.wdg.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wdg.api.pojo.Simple;
import com.wdg.api.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "1.0.0",timeout = 300)
    private HelloService service;

    @GetMapping("hi")
    public String hi(Simple simple){
        return service.hi(simple);
    }
}
