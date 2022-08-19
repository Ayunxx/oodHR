package com.oodhr.admin.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.oodhr.admin.mapper.DepartmentMapper;
import com.oodhr.admin.entity.DepartmentEntity;
import com.oodhr.admin.service.DepartmentService;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentEntity> implements DepartmentService {


}