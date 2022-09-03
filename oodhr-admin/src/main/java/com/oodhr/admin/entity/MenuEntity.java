package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/8/27 14:31
 */
@Data
@TableName("menu")
public class MenuEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String menuName;

    private String component;

    private String path;

    private String status;

    private String perms;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private  Date updateTime;

    private String remark;

    @TableLogic
    private Integer delFlag;


}
