package com.wdg.api.service;


import com.wdg.api.pojo.Simple;

/**
 *  @Description 用户操作
 *
 *  @author wudiguang
 *  @Date 2021/11/14
 *  @version 1.0.0
 *  @dubbo
 */

public interface HelloService {
    /**
     * 打招呼
     * @param simple 姓名
     * @return 打招呼内容
     */
    String hi(Simple simple);
}
