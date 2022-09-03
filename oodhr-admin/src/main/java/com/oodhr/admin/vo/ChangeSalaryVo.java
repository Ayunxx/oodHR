package com.oodhr.admin.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/8/22 11:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeSalaryVo implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 调薪日期
     */
    private Date asDate;

    /**
     * 调前薪资
     */
    private Integer beforeSalary;

    /**
     * 调后薪资
     */
    private Integer afterSalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;

    private String workId;

    private String empName;
}
