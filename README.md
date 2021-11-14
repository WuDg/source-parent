# 最佳实践

## mybatis-plus 定制化代码生成

## smart-doc 零代码侵入文档生成

## 项目结构

### source-parent
统一化依赖版本

### mybatis-plus
代码生成工具，生成的代码直接在 springboot mybatis项目中使用
需要引入 tk 相关依赖 & 需要复制 com/wdg/mybatisplus/base 下面相关类到项目中

### service-api
为dubbo api

### dubbo-doc
为 dubbo provider

### dubbo-doc-consumer
为 dubbo-consumer