package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.EmployeeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oodhr.admin.vo.EmployeeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 
 * 
 * @author Ayun
 * @email Ayunlccy@gmail.com
 * @date 2022-08-16 12:24:09
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {

    /**
     * 传入一个workid 查看
     * @param workid
     */
    Boolean getWorkid(@Param("workid") String workid);



    @Select("SELECT e.*,d.name as departmentname ,n.name as nationname,j.name as joblevelname,p.name as posname " +
            "FROM employee e " +
            "left join department d on e.departmentId = d.id " +
            "Left join nation n on e.nationId = n.id " +
            "LEFT JOIN joblevel j on e.jobLevelId = j.id " +
            "left join position p on e.posId = p.id " +
            "${ew.customSqlSegment}"
            )
    IPage<EmployeeEntity> getList(Page<EmployeeEntity> page, @Param(Constants.WRAPPER)Wrapper<EmployeeEntity> wrapper);
}
