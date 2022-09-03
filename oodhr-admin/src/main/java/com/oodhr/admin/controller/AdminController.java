package com.oodhr.admin.controller;

import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.entity.RoleEntity;
import com.oodhr.admin.service.HrService;
import com.oodhr.admin.service.MenuService;
import com.oodhr.admin.service.RoleService;
import com.oodhr.admin.service.impl.HrServiceImpl;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.MenuVo;
import com.oodhr.admin.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/31 13:45
 */

@RestController
@CrossOrigin
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('system:admin')")
public class AdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private HrService hrService;

    @Autowired
    private MenuService menuService;


    @PutMapping("/updateRoleStatus/{roleId}/{menuId}/{status}")
    public Result updateRoleStatus(@PathVariable Integer roleId,
                                   @PathVariable Integer menuId,
                                   @PathVariable Integer status){
        boolean flag = roleService.updateRoleStatus(roleId, menuId, status);
        if (flag) {
            return  Result.ok();
        } else{
            return  Result.fail();
        }

    }

    @GetMapping("/getRoleAndMenu")
    public Result getRoleAndMenu(){
        List<MenuVo> list = menuService.getRoleAndMenuList();
        return Result.ok(list);
    }

    /**
     * 获取菜单列表
     * @return
     */
    @GetMapping("/getMenuList")
    public Result getMenuList(){

        List<MenuVo> list = menuService.getMenuList();

        return Result.ok(list);
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/getUserList")
    public Result getUserList(){
        List<HrVo> list = hrService.getUserList();

        return Result.ok(list);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Integer id){
        boolean flag = hrService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }
    /**
     * 新增
     * @param hrEntity
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody HrEntity hrEntity){
        HrEntity entity = hrService.encryption(hrEntity);
        boolean flag = hrService.save(entity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 限制登录
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/updateUserStatusById/{id}/{status}")
    public Result updateUserStatusById(@PathVariable Integer id,
                                   @PathVariable Integer status){

        Boolean flag = roleService.updateUserStatusById(id, status);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
