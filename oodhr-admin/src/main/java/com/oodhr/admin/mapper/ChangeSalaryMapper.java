package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.ChangeSalaryEntity;
import com.oodhr.admin.vo.ChangeSalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther Ayun
 * @date 2022/8/22 11:24
 */
@Mapper
public interface ChangeSalaryMapper extends BaseMapper<ChangeSalaryEntity> {


    @Select("select sal.*,e.workId,e.emp_name " +
            "from sal_changesalary sal " +
            "left join employee e " +
            "on e.id = sal.eid" +
            "${ew.customSqlSegment}")
    IPage<ChangeSalaryVo> getPage(Page<ChangeSalaryVo> voPage, @Param(Constants.WRAPPER) QueryWrapper<ChangeSalaryVo> queryWrapper);
}
