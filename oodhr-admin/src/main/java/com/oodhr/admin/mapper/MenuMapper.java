package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oodhr.admin.entity.MenuEntity;
import com.oodhr.admin.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/27 14:39
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

    @Select("select DISTINCT m.perms " +
            "from hr_role hhr " +
            "left join role r on role_id = r.id " +
            "left join role_menu rm on hhr.role_id = rm.role_id " +
            "left join menu m on m.id = rm.menu_id " +
            "where hr_id = #{hrId}  " +
            "and r.`status` = 0 " +
            "and m.`status` = 0 ")
    List<String> selectPermsByHrId(Integer hrId);

    @Select("select * from menu")
    List<MenuVo> getMenuList();


    @Select("select rm.*,r.role_name,r.role_key,m.menu_name,m.perms " +
            "from role_menu rm " +
            "left join menu m on m.id = rm.menu_id " +
            "left join role r on r.id = rm.role_id")
    List<MenuVo> getRoleAndMenu();
}
