package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.RoleEntity;
import com.oodhr.admin.mapper.RoleMapper;
import com.oodhr.admin.service.RoleService;
import com.oodhr.admin.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/9/1 20:52
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;




    @Override
    public boolean updateUserStatusById(Integer id, Integer status) {
        Boolean flag = roleMapper.updateUserStatusById(id, status);
        return flag;
    }

    @Override
    public boolean updateRoleStatus(Integer roleId, Integer menuId, Integer status) {

        //TODO 删除redis中的缓存 重新获取

        boolean flag = roleMapper.updateRoleStatusById(roleId, menuId, status);

        return flag;
    }
}
