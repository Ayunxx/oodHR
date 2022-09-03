package com.oodhr.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.MenuEntity;
import com.oodhr.admin.vo.MenuVo;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/9/2 10:55
 */
public interface MenuService extends IService<MenuEntity> {
    List<MenuVo> getMenuList();

    List<MenuVo> getRoleAndMenuList();
}
