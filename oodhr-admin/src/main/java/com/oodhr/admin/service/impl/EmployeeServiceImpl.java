package com.oodhr.admin.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.*;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.mapper.EmployeeMapper;
import com.oodhr.admin.service.EmployeeService;
import org.springframework.util.StringUtils;

import java.util.List;


@Service("employeeService")
    public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public EmployeeEntity checkWorkId(EmployeeEntity employeeEntity) {
        String workid = employeeEntity.getWorkid();
        Boolean flag = employeeMapper.getWorkid(workid);
        if (flag==null){

            return employeeEntity;
        } else {
            return null;
        }


    }

    @Override
    public IPage<EmployeeEntity> getListPage(Long current, Long size,EmployeeVo employeeVo) {


        //构建条件
        String workid = employeeVo.getWorkId();
        String name = employeeVo.getEmpName();
        QueryWrapper<EmployeeEntity> employeeEntityQueryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(workid)) {
            employeeEntityQueryWrapper.like("workid",workid);
        }
        if (StringUtils.hasText(name)) {
            employeeEntityQueryWrapper.like("empname",name);
        }
        Page<EmployeeEntity> entityPage = new Page<>(current,size);
        IPage<EmployeeEntity> pageList = employeeMapper.getList(entityPage,employeeEntityQueryWrapper);
        return pageList;
    }

    @Override
    public List<NationEntity> getNation() {

        List<NationEntity> nationList = employeeMapper.getNationList();

        return nationList;
    }

    @Override
    public List<DepartmentEntity> getDepartment() {
        List<DepartmentEntity> departmentList = employeeMapper.getDepartmentList();

        return departmentList;
    }

    @Override
    public List<JobLevelEntity> getJobLevel() {
        List<JobLevelEntity> jobLevelList = employeeMapper.getJobLevelList();
        return jobLevelList;
    }

    @Override
    public List<PositionEntity> getPosition() {
        List<PositionEntity> positionList = employeeMapper.getPositionList();
        return positionList;
    }


}