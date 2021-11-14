package com.wdg.mybatisplus.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 *  @Description 自定义BaseMapper，增强 tk mapper
 *  
 *  @author wudiguang
 *  @Date 2021/11/14
 */ 
public interface BaseMapper<T> extends Mapper<T>, DeleteByIdsMapper<T> {
}
