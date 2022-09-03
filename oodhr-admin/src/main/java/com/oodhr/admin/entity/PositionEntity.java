package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/9/1 11:56
 */
@Data
@TableName("position")
public class PositionEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String posName;

    private Date createDate;

    private Integer enabled;


}
