package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.*;
import com.oodhr.admin.vo.EmployeeVo;

import java.util.List;

/**
 * 
 *
 * @author Ayun
 * @email Ayunlccy@gmail.com
 * @date 2022-08-16 12:24:09
 */
public interface EmployeeService extends IService<EmployeeEntity> {


    EmployeeEntity checkWorkId(EmployeeEntity employeeEntity);


    IPage<EmployeeEntity> getListPage(Long current, Long size,EmployeeVo employeeVo);

    List<NationEntity> getNation();

    List<DepartmentEntity> getDepartment();

    List<JobLevelEntity> getJobLevel();

    List<PositionEntity> getPosition();
}

