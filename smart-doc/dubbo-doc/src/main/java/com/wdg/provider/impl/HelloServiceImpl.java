package com.wdg.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wdg.api.pojo.Simple;
import com.wdg.api.service.HelloService;

/**
 *  @Description 测试实现类
 *
 *  @author wudiguang
 *  @Date 2021/11/14
 */
@Service(version = "1.0.0",timeout = 3000)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hi(Simple simple) {
        return String.format("%s %s", "Hi", simple.getName());
    }
}
