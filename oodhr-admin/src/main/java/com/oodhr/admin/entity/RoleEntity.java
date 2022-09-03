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
 * @date 2022/9/1 20:44
 */
@Data
@TableName("role")
public class RoleEntity implements Serializable {
    private final static long serialVersionUID = 1L;


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String roleName;

    private String roleKey;

    private Integer status;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String remark;

    @TableLogic
    private Integer delFlag;
}
