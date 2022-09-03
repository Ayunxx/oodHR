package com.oodhr.admin.controller;



import com.oodhr.admin.entity.DepartmentEntity;
import com.oodhr.admin.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.oodhr.admin.service.DepartmentService;

import java.util.List;


/**
 * 
 *
 * @author Ayun
 * @email Ayunlccy@gmail.com
 * @date 2022-08-16 12:24:09
 */
@RestController
@RequestMapping("/department")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:department')")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;



    @PreAuthorize("hasAnyAuthority('system:department:list','system:department')")
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList(){
        List<DepartmentEntity> list = departmentService.list();

        return Result.ok(list);
    }



}
