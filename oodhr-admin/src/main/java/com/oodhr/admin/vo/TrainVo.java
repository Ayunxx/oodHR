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
 * @date 2022/8/19 12:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainVo implements Serializable {
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

    /**
     * 员工姓名
     */
    private String empName;


    private String workId;
}
