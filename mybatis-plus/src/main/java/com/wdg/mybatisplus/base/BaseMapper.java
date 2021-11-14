package com.wdg.mybatisplus.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

public interface BaseMapper<T> extends Mapper<T>, DeleteByIdsMapper<T> {
}
