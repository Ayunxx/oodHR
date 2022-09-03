package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HrMapper extends BaseMapper<HrEntity> {
    HrEntity verify(HrVo user);

    @Select("select id,username,password,avatar "+
            "from hr " +
            "${ew.customSqlSegment} "+
            "and status = 0 " +
            "and del_flag = 0")
    HrVo getOneByUsername (@Param(Constants.WRAPPER)Wrapper<HrVo> wrapper);

    @Select("select h.id,h.hr_name,h.phone,h.username,h.avatar,h.remark,h.status,r.role_key,r.role_name,h.del_flag " +
            "from hr h " +
            "left join role r on r.id = h.id " +
            "where h.del_flag = 0")
    List<HrVo> getUserList();
}
