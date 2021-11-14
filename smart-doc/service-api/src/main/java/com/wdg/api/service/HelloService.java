package com.wdg.api.service;


import com.wdg.api.pojo.Simple;

/**
 * 用户操作
 *
 * @author yu 2019/4/22.
 * @author zhangsan 2019/4/22.
 * @version 1.0.0
 * @dubbo
 */

public interface HelloService {
    /**
     * 查询所有用户
     * @param name 姓名
     * @return 打招呼
     */
    String hi(Simple simple);
}
