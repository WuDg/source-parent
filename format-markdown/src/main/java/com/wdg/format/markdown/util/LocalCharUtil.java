package com.wdg.format.markdown.util;

import cn.hutool.core.util.CharUtil;

/**
 *  @Description 字符工具
 *
 *  @author wudiguang
 *  @Date 2021/12/23
 */
public class LocalCharUtil {
    private LocalCharUtil(){}
    public static boolean isEnglishChar(char c){
        return CharUtil.isLetter(c);
    }
    public static boolean isChineseChar(char c){
        if(c >= 0x0391 && c <= 0xFFE5) {
            //中文字符
            return true;
        }
        return false;
    }
    public static boolean isBetweenChineseAndNumber(char c1, char c2){
        boolean betweenChineseAndNumber = (isChineseChar(c1) && CharUtil.isNumber(c2)) || (isChineseChar(c2) && CharUtil.isNumber(c1));
        if(betweenChineseAndNumber){
            return true;
        }
        return false;
    }
}
