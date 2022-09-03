package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/8/19 16:58
 */
@Data
@TableName("emp_rewardandpunish")
public class RandPEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * eid 员工id
     */
    private Integer eid;

    /**
     * 奖惩时间
     */
    private Date ecDate;

    /**
     * 原因
     */
    private String ecReason;

    /**
     * 奖惩分数
     */
    private Integer ecPoint;

    /**
     * 类型
     */
    private String ecType;

    /**
     * 备注
     */
    private String remark;

    @TableLogic
    private Integer delFlag;

}
