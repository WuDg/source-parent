package com.wdg.format.markdown.util;

import cn.hutool.core.io.IoUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *  @Description 读取文件工具类
 *
 *  @author wudiguang
 *  @Date 2021/12/22
 */
public class FileReadUtil {
    /**
     * read file
     * @param path
     * @return
     */
    public static BufferedReader readFileFromPath(String path){
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            InputStream inputStream =classPathResource.getInputStream();
            return new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
