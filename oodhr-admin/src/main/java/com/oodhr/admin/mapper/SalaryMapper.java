package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.SalaryEntity;
import com.oodhr.admin.vo.SalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/21 19:08
 */
@Mapper
public interface SalaryMapper extends BaseMapper<SalaryEntity> {

    @Select("select sa.*,e.emp_name,e.workID " +
            "from salary sa " +
            "left join employee e " +
            "on e.id = sa.eid" +
            "${ew.customSqlSegment}")
    IPage<SalaryVo> getListPage(Page<SalaryVo> voPage,@Param(Constants.WRAPPER) QueryWrapper<SalaryVo> voQueryWrapper);


    @Select("select s.*,e.emp_name " +
            "from salary s " +
            "left join employee e on s.eid = e.id " +
            "where s.del_flag = 0 " +
            "and s.id = #{id}")
    SalaryVo getById(@Param("id") Integer id);
}
