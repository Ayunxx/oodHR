package com.oodhr.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther Ayun
 * @date 2022/9/2 16:03
 */
@Data
public class RoleMenuEntity implements Serializable {
    private  final  static  long serialVersionUID = 1L;

    private Integer roleId;

    private Integer menuId;

    private Integer status;

}
