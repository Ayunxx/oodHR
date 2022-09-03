package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.MenuEntity;
import com.oodhr.admin.mapper.EmployeeMapper;
import com.oodhr.admin.mapper.MenuMapper;
import com.oodhr.admin.service.MenuService;
import com.oodhr.admin.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/9/2 10:56
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<MenuVo> getMenuList() {
        List<MenuVo> menuList = menuMapper.getMenuList();
        return menuList;
    }

    @Override
    public List<MenuVo> getRoleAndMenuList() {

        List<MenuVo> menuVoList = menuMapper.getRoleAndMenu();
        return menuVoList;
    }
}
