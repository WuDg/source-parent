package com.wdg.mybatisplus.base;

import lombok.Data;

import java.io.Serializable;

/**
 *  @Description 通用封装类基类
 *
 *  @author wudiguang
 *  @Date 2021/11/14
 */

@Data
public class BaseResult<T> implements Serializable {

    public boolean success = false;

    public String message;

    public T data;

    public String code;

    public String timestamp;
}