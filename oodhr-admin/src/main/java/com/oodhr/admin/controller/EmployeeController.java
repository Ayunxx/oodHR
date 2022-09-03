package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.*;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.oodhr.admin.service.EmployeeService;

import java.util.List;


/**
 * 
 *
 * @author Ayun
 * @email Ayunlccy@gmail.com
 * @date 2022-08-16 12:24:09
 */
@RestController
@RequestMapping("/employee")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:employee')")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    /**
     * 获取员工列表并分页
     * @param current
     * @param size
     * @return
     */

    @PreAuthorize("hasAnyAuthority('system:employee:list','system:employee')")
    @PostMapping("/getEmployeeList/{current}/{size}")
    public Result getEmployeeList(@PathVariable Long current,
                                  @PathVariable Long size,
                                  @RequestBody EmployeeVo employeeVo
    ){
        IPage<EmployeeEntity> entityIPage = employeeService.getListPage(current, size,employeeVo);

        return Result.ok(entityIPage);
    }

    /**
     * 添加员工
     * @param employeeEntity
     * @return
     */
    @PostMapping("/addEmployee")
    public Result addEmployee(@RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity checkWorkId = employeeService.checkWorkId(employeeEntity);

        if (!checkWorkId.equals(null)){
            employeeService.save(checkWorkId);

        } else {
            Result.fail("添加失败");
        }
        return Result.ok();
    }

    /**
     * 修改员工信息
     * @param employeeEntity
     * @return
     */
    @PostMapping("/updateEmployee")
    public Result updateEmployee(@RequestBody EmployeeEntity employeeEntity){

        boolean flag = employeeService.updateById(employeeEntity);

        if (flag){
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/getEmployeeById/{id}")
    public Result getEmployeeById(@PathVariable Integer id){

        EmployeeEntity employeeServiceById = employeeService.getById(id);

        return Result.ok(employeeServiceById);

    }

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployeeById/{id}")
    public Result deleteEmployeeById(@PathVariable Long id){

        boolean flag = employeeService.removeById(id);

        if (flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 获取民族列表
     * @return
     */
    @GetMapping("/getNationList")
    public Result getNationList(){
       List<NationEntity> list =  employeeService.getNation();

       return Result.ok(list);
    }

    /**
     * 获取部门列表
     * @return
     */
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList(){
        List<DepartmentEntity> list = employeeService.getDepartment();
        return Result.ok(list);
    }

    /**
     * 获取职称列表
     * @return
     */
    @GetMapping("/getJobLevelList")
    public Result getJobLevelList(){
        List<JobLevelEntity> list = employeeService.getJobLevel();
        return Result.ok(list);
    }

    /**
     * 获取职位列表
     * @return
     */
    @GetMapping("/getPositionList")
    public Result getPositionList(){

        List<PositionEntity> list = employeeService.getPosition();

        return Result.ok(list);
    }
}
