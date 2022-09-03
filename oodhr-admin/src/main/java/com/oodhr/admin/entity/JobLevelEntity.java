package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/9/1 11:45
 */
@Data
@TableName("joblevel")
public class JobLevelEntity implements Serializable {
    private final static long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String jobName;

    /**
     * 职称级别
     */
    private String titleLevel;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 是否扩建
     */
    private Integer enabled;

}
