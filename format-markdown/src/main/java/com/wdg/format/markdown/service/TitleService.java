package com.wdg.format.markdown.service;

import java.io.BufferedReader;
import java.util.Stack;

/**
 *  @Description 标题 Service
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */ 
public interface TitleService {
    /**
     * 标题
     * 原则：
     *      (1) 一级标题下，不能直接出现三级标题
     *      (2) 标题要避免孤立编号（即同级标题只有一个）
     *      (3) 下级标题不重复上一级标题的名字
     *      (4) 谨慎使用四级标题，尽量避免出现，保持层级的简单，防止出现过于复杂的章节
     *
     * @param path
     */
    void formatTitle(String path);

    /**
     * 标题层级
     * @param reader
     */
    void formatTitleHierarchy(BufferedReader reader);

    /**
     * 格式化剩余的标题数据
     * @param titleStack
     * @param lastTitleStart
     */
    void clearOrderTitle(Stack<String> titleStack, String lastTitleStart);

    /**
     * 处理栈逻辑
     * @param titleStack
     * @param lineText
     */
    String circuitProcessStack(Stack<String> titleStack, String lineText, String lastTitleStartFixed);

    /**
     * 获取标题开头字符串，如 ####
     * @param title
     * @return
     */
    String getTitleStart(String title);
}
