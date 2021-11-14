package com.wdg.mybatisplus.controller;

import com.wdg.mybatisplus.entity.Simple;
import com.wdg.mybatisplus.service.ISimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author wudiguang
 * @since 2021-11-13
 */

@RestController
@RequestMapping("/simple")
public class SimpleController {
    @Autowired
    private ISimpleService service;


    /**
     * 查询List
     * @param simple 参数
     * @return 条件查询的数据
     */
    @ResponseBody
    @PostMapping("/select")
    public Object select(@RequestBody Simple simple){
        System.out.printf("%s name:%s%n", "Hi", simple.getName());
        return service.select();
    }
}
