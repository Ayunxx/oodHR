package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @auther Ayun
 * @date 2022/9/1 10:44
 */
@Data
@TableName("nation")
public class NationEntity implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id;

    private String natName;
}
