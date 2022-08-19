package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/8/19 19:14
 */
@Data
@TableName("emp_assessment")
public class AssessmentEntity implements Serializable {
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
     * 考核时间
     */
    private Date appDate;

    /**
     * 考核结果
     */
    private String appResult;

    /**
     * 考核内容
     */
    private String appContent;

    /**
     * 备注
     */
    private String remark;

}
