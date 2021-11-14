# 最佳实践

## 一 mybatis-plus 定制化代码生成

## 二 smart-doc 零代码侵入文档生成

[smart-doc](https://smart-doc-group.github.io/#/zh-cn/start/quickstart)
### 使用方法
1. 引入smart-doc 的maven插件
```xml
<plugin>
    <groupId>com.github.shalousun</groupId>
    <artifactId>smart-doc-maven-plugin</artifactId>
    <version>2.2.1</version>
    <configuration>
        <!--指定生成文档使用的配置文件-->
        <configFile>./src/main/resources/smart-doc.json</configFile>
        <!--指定分析的依赖模块（避免分析所有依赖，导致生成文档变慢，循环依赖导致生成失败等问题）-->
        <includes>
            <!--格式为：groupId:artifactId;参考如下-->
            <include>com.alibaba:fastjson</include>

        </includes>
    </configuration>
    <executions>
        <execution>
            <!--不需要在编译项目时自动生成文档可注释phase-->
            <phase>compile</phase>
            <goals>
                <goal>html</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
### maven sources 目录下新建 smart-doc.json
> 配置服务地址（页面请求展示）
配置生成文档路径


```json
{
  "serverUrl": "http://127.0.0.1:8080",
  "isStrict": false,
  "allInOne": true,
  "outPath": "src/main/resources/static/doc",
  "createDebugPage": true,
  "projectName": "smart-doc"
}
```

### 使用插件
* smart-doc:html 普通 springboot 项目
* smart-doc:rpc-html dubbo 项目


## 三 项目结构

### 1. source-parent
统一化依赖版本

### 2. mybatis-plus
代码生成工具，生成的代码直接在 springboot mybatis项目中使用
需要引入 tk 相关依赖 & 需要复制 com/wdg/mybatisplus/base 下面相关类到项目中

### 3. service-api
为dubbo api

### 4. dubbo-doc
为 dubbo provider

### 5. dubbo-doc-consumer
为 dubbo-consumer