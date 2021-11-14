package com.wdg.mybatisplus.service.impl;

import com.wdg.mybatisplus.entity.Simple;
import com.wdg.mybatisplus.mapper.SimpleMapper;
import com.wdg.mybatisplus.service.ISimpleService;
import com.wdg.mybatisplus.base.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author wudiguang
 * @since 2021-11-13
 */
@Service
public class SimpleServiceImpl extends ServiceImpl<SimpleMapper, Simple> implements ISimpleService {
    @Autowired
    private SimpleMapper mapper;

    @Override
    public List<Simple> select() {
        return mapper.selectAll();
    }
}
