package com.oodhr.admin.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther Ayun
 * @date 2022/9/1 20:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer id;

    private String roleName;

    private String roleKey;

    private Integer status;


    private String remark;

    @TableLogic
    private Integer delFlag;

}
