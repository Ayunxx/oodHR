package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.ChangeJobEntity;
import com.oodhr.admin.vo.ChangeJobVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther Ayun
 * @date 2022/8/19 20:21
 */
@Mapper
public interface ChangeJobMapper extends BaseMapper<ChangeJobEntity> {

    @Select("select cj.*,e.emp_name,e.workid " +
            "from emp_changejob cj " +
            "left join employee e " +
            "on cj.eid = e.id"+
            "${ew.customSqlSegment}")
    IPage<ChangeJobVo> getListPage(Page<ChangeJobVo> jobVoPage, @Param(Constants.WRAPPER) QueryWrapper<ChangeJobVo> queryWrapper);
}
