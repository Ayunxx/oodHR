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
 * @date 2022/8/19 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandPVo implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 主键id
     */
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
    private Integer ecType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 工号
     */
    private String workId;
}
