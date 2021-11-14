package com.wdg.mybatisplus.service;

import com.wdg.mybatisplus.entity.Simple;
import com.wdg.mybatisplus.base.IService;

import java.util.List;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author wudiguang
 * @since 2021-11-13
 */
public interface ISimpleService extends IService<Simple> {
    /**
     * 查润 List
     * @return
     */
    List<Simple> select();
}
