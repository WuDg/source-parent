package com.wdg.format.markdown.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdg.format.markdown.service.CoreService;
import com.wdg.format.markdown.service.TitleService;
import com.wdg.format.markdown.util.FileReadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  @Description 核心 Impl
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */
@Service
@Slf4j
public class CoreServiceImpl implements CoreService {

    private static final Pattern pattern = Pattern.compile("#*");

    @Autowired
    private TitleService titleService;

    @Override
    public String formatText(String path) throws Exception {
        // 标题
        titleService.formatTitle(path);
        // 文本

        // 段落

        // 数值

        // 标签符号

        // 文档体系

        // 参考链接
        return null;
    }

    public static void main(String[] args) {
        String content = "### 1.1 同一节点间的 `Pod` 网络";
        String pattern = "#*";
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(content);
        if(m.find()){
            log.info(m.group());
        }
    }
}
