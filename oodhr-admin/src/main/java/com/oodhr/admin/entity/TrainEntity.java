package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/8/19 12:16
 */
@Data
@TableName("emp_train")
public class TrainEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键 id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 培训日期
     */
    private Date trainDate;

    /**
     * 培训内容
     */
    private String trainContent;

    /**
     * 备注
     */
    private String remark;


    @TableField(exist = false)
    private String empName;

    @TableLogic
    private Integer delFlag;
}
