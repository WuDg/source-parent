package com.wdg.format.markdown.controller;

import com.wdg.format.markdown.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  @Description 核心接口-前端控制器
 *  
 *  @author wudiguang
 *  @Date 2021/12/22
 */
@RestController
@RequestMapping("/core")
public class CoreController {
    @Autowired
    private CoreService service;

    /**
     * 接收 Markdown格式文本
     * @param path
     */
    @PostMapping("/receiveDoc")
    public void receiveDoc(String path) throws Exception {
        String formatText = service.formatText(path);
    }
}
