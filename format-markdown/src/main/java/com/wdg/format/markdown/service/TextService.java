package com.wdg.format.markdown.service;

import java.io.BufferedReader;

/**
 *  @Description 文本 Service
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */ 
public interface TextService {
    /**
     * 格式化文本
     * @param path
     */
    void formatText(String path);

    /**
     * 文本字间距
     * @param reader
     */
    void formatTextWordSpacing(BufferedReader reader);

    /**
     * 单行文本字间距
     * @param lineText
     */
    void formatTextWordSpacingCharSingleLine(String lineText, StringBuffer newText);
}
