package com.wdg.format.markdown.service;

/**
 *  @Description 核心 Service
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */ 
public interface CoreService {
    /**
     * 接收并格式化文档
     * @param path
     * @return
     */
    String formatText(String path) throws Exception;
}
