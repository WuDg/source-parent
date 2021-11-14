package com.wdg.mybatisplus.base;

import lombok.Getter;

/**
 *  @Description 消息枚举
 *  
 *  @author wudiguang
 *  @Date 2021/11/14
 */ 

@Getter
public enum IMessage {
    PASS("200", "SUCCESS"),
    UNKNOWN_ERROR("200", "SUCCESS"),
    SUCCESS("200", "SUCCESS");
    private String code;
    private String message;
    IMessage(String code, String message){
        this.code = code;
        this.message = message;
    }
}
