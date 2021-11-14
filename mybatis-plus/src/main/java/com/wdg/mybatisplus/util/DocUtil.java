package com.wdg.mybatisplus.util;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;

public class DocUtil {
    /**
     * 测试生成文档
     */
    public static void main(String[] args) {
        generator();
    }
    public static void generator() {
        ApiConfig config = new ApiConfig();
        //服务地址
        config.setServerUrl("http://192.168.1.15:8080");//接口地址:
        //生成到一个文档
//        config.setAllInOne(true);
        //采用严格模式
        config.isStrict();
        //文档输出路径
        config.setOutPath("C://wudiguang//code//source-parent//mybatis-plus//doc");//这里的话 需要自己定义下文件的地址哈
        ApiDocBuilder.builderControllersApi(config);
        //将生成的文档输出到/Users/dujf/Downloads/md目录下，严格模式下api-doc会检测Controller的接口注释
    }
}
