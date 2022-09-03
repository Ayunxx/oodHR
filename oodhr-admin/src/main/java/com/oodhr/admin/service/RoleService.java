package com.oodhr.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.RoleEntity;
import com.oodhr.admin.vo.RoleVo;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/9/1 20:52
 */
public interface RoleService extends IService<RoleEntity> {

    boolean updateUserStatusById(Integer id, Integer status);

    boolean updateRoleStatus(Integer roleId, Integer menuId, Integer status);
}
