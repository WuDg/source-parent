package com.wdg.mybatisplus.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult<T> implements Serializable {

    public boolean success = false;

    public String message;

    public T data;

    public String code;

    public String timestamp;
}