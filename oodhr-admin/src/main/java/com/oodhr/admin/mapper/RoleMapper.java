package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oodhr.admin.entity.RoleEntity;
import com.oodhr.admin.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/9/1 20:53
 */

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {



    /**
     * 改变状态限制登录
     * @param id
     * @param status
     * @return
     */
    @Update("update hr set status = ${status} where id = #{id}")
    boolean updateUserStatusById(@Param("id") Integer id, @Param("status") Integer status);

    @Update("update role_menu set status = #{status} where role_id = #{roleId} and menu_id = #{menuId}")
    boolean updateRoleStatusById(@Param("roleId") Integer roleId,@Param("menuId") Integer menuId,@Param("status") Integer status);
}
