package com.oodhr.admin.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/9/2 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id;

    private String menuName;

    private String component;

    private String path;

    private String status;

    private String perms;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private  Date updateTime;

    private String remark;

    private String roleId;

    private String menuId;

    private String roleName;

    private String roleKey;
}
