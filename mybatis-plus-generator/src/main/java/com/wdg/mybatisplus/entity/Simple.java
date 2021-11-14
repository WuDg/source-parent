package com.wdg.mybatisplus.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author wudiguang
 * @since 2021-11-13
 */
@Data
@Table(name = "simple")
public class Simple implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 删除标识1
     */
    private Boolean deleteFlag;

    /**
     * 删除标识2
     */
    private Boolean deleted;

    /**
     * 版本
     */
    private Long version;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
