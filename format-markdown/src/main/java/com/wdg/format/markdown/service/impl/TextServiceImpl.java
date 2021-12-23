package com.wdg.format.markdown.service.impl;

import cn.hutool.core.util.CharUtil;
import com.wdg.format.markdown.service.TextService;
import com.wdg.format.markdown.util.LocalCharUtil;
import com.wdg.format.markdown.util.FileReadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;

/**
 *  @Description 文本 Impl
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */
@Service
@Slf4j
public class TextServiceImpl implements TextService {
    @Override
    public void formatText(String path) {
        // 将文本单独提取出来，判断是否服务规则，不符合则给出提示
        log.info(path);
        BufferedReader reader = FileReadUtil.readFileFromPath("kubernetes_network.md");
        formatTextWordSpacing(reader);
    }

    public void formatTextWordSpacing(BufferedReader reader) {
        try {
            String lineText;
            int lineNumber = 1;
            // 当前文本中文字符与半角阿拉伯数字之间是否有半角空格，必须保证风格统一
            // 0 表示还未找到中文字符与半角阿拉伯数字之间是否有空格
            // 1 表示当前统一为没有空格
            // 2 表示当前统一为有空格

            int numberType = 0;
            StringBuffer outText = new StringBuffer();
            StringBuffer sourceText = new StringBuffer();
            while((lineText = reader.readLine()) != null){
                sourceText.append(lineText).append('\n');
                log.debug("[原始文本] 当前行号为:{}，当前行文本为:{}", lineNumber, lineText);
                StringBuffer newText = new StringBuffer();
                formatTextWordSpacingCharSingleLine(lineText, newText);
                log.info("[推荐文本] [中文-英文] 当前行号为:{}，当前行文本为:{}，推荐新文本:{}", lineNumber, lineText, newText.toString());
                lineText = newText.toString();
                newText = new StringBuffer();
                numberType = formatTextWordSpacingNumberSingleLine(lineText, numberType, newText);
                log.info("[推荐文本] [中文-数字] 当前行号为:{}，当前行文本为:{}，推荐新文本:{}", lineNumber, lineText, newText.toString());
                lineNumber++;
                outText.append(newText.toString()).append('\n');
            }
            log.info("[结果] ----------------------");
            log.info("[原始数据] 原始:\n{}", sourceText.toString());
            log.info("[最终结果] 推荐:\n{}", outText.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private int formatTextWordSpacingNumberSingleLine(String lineText, int numberType, StringBuffer newText) {
        lineText = lineText.trim();
        if(!StringUtils.hasText(lineText)){
            return numberType;
        }
        char[] chars = lineText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || CharUtil.isBlankChar(chars[i])) {
                newText.append(chars[i]);
                continue;
            }
            boolean isBetweenChineseAndNumberNext = LocalCharUtil.isBetweenChineseAndNumber(chars[i], chars[i - 1]);

            boolean hasAlter = false;
            if(isBetweenChineseAndNumberNext){
                if(numberType == 0){
                    // 遍历到无空格的相邻中文字符与半角阿拉伯数字
                    numberType = 1;
                    log.debug("[文本] 相邻中文字符与半角阿拉伯数字无空格，当前字符为:{}，上一个字符为:{}", chars[i], chars[i - 1]);
                }else if(numberType == 2){
                    log.debug("[文本] 相邻中文字符与半角阿拉伯数字有空格，当前字符为:{}，上一个字符为:{}, 上一次检测到有空格", chars[i], chars[i - 1]);
                    log.debug("[文本] 拼接字符串，拼接前字符串为:{}", newText.toString());
                    newText.append(" ").append(chars[i]);
//                    log.info("[文本] 拼接字符串，拼接后字符串为:{}", newText.toString());
                    hasAlter = true;
                }
            }
            if(i > 1){
                boolean isBetweenChineseAndNumberTwoSpace = LocalCharUtil.isBetweenChineseAndNumber(chars[i], chars[i - 2]);
                // 遍历到有空格的相邻中文字符与半角阿拉伯数字
                if(isBetweenChineseAndNumberTwoSpace && CharUtil.isBlankChar(chars[i - 1])){
                    if(numberType == 0){
                        numberType = 2;
                        log.debug("[文本] 相邻中文字符与半角阿拉伯数字有空格，当前字符为:{}，上两个字符为:{}", chars[i], chars[i - 2]);
                    }else if(numberType == 1){
                        newText.deleteCharAt(newText.length() - 1);
                        newText.append(chars[i]);
                        log.debug("[文本] 相邻中文字符与半角阿拉伯数字有空格，当前字符为:{}，上两个字符为:{}, 上一次检测到无空格，新字符:{}", chars[i], chars[i - 2], newText.toString());
                        hasAlter = true;
                    }
                }
            }
            if(!hasAlter){
                log.debug("[文本] 未被改变，拼接字符串，拼接前字符串为:{}", newText.toString());
                newText.append(chars[i]);
                log.debug("[文本] 未被改变，拼接字符串，拼接后字符串为:{}", newText.toString());
            }
        }
        return numberType;
    }

    public void formatTextWordSpacingCharSingleLine(String lineText, StringBuffer newText) {
        lineText = lineText.trim();
        if(!StringUtils.hasText(lineText)){
            return;
        }
        char[] chars = lineText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i == 0 || CharUtil.isBlankChar(chars[i])){
                newText.append(chars[i]);
                log.debug("[文本] 拼接字符串，拼接后字符串为:{}", newText.toString());
                continue;
            }
            boolean isEnglishNowChar = LocalCharUtil.isEnglishChar(chars[i]);
            boolean isEnglishLastChar = LocalCharUtil.isEnglishChar(chars[i - 1]);
            boolean nextSpace = (isEnglishNowChar && LocalCharUtil.isChineseChar(chars[i - 1])) || (LocalCharUtil.isChineseChar(chars[i]) && isEnglishLastChar);
            if(nextSpace){
                newText.append(" ").append(chars[i]);
                log.debug("[文本] 拼接字符串-全角中文字符与半角英文字符之间应该增加空格，拼接后字符串为:{}", newText.toString());
            }else {
                newText.append(chars[i]);
            }
        }
    }
}
