package com.wdg.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

/**
 * <p>
 * 快速生成
 * </p>
 *
 * @author wudiguang
 * @since 2021-09-16
 */

public class Generator {
    /**
     * 执行初始化数据库脚本
     */
    public static void before() throws SQLException {
        Connection conn = DATA_SOURCE_CONFIG.build().getConn();
        InputStream inputStream = Generator.class.getResourceAsStream("/sql/init.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://IP:3306/generator?useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=Asia/Shanghai", "root", "");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        before();
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author("wudiguang")
//                        .outputDir("C://wudiguang//code//source-parent//mybatis-plus//src//main//java")
                        .outputDir("C://wudiguang//code//source-parent//mybatis-plus//code")
                        .fileOverride())
                // 包配置
                .packageConfig((scanner, builder) -> builder
                        .parent("com.wdg.mybatisplus")
//                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C://wudiguang//code//source-parent//mybatis-plus//src//main//resources//com//wdg//mybatisplus")))
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C://wudiguang//code//source-parent//mybatis-plus//codes")))
                // 策略配置
                .strategyConfig(builder -> builder.addInclude("simple")
                        .controllerBuilder().enableRestStyle()
                )
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }
}
