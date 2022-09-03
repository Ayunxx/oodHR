package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.service.ChangeJobService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.ChangeJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @auther Ayun
 * @date 2022/8/19 20:11
 */
@RestController
@RequestMapping("/changejob")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:changejob')")
public class ChangeJobController {

    @Autowired
    private ChangeJobService changeJobService;


    @PreAuthorize("hasAnyAuthority('system:changejob:list','system:changejob')")
    @PostMapping("/getChangeJobList/{current}/{size}")
    public Result getChangeJobList(@PathVariable Long current,
                                   @PathVariable Long size,
                                   @RequestBody ChangeJobVo changeJobVo){

        IPage<ChangeJobVo> page = changeJobService.getPage(current, size, changeJobVo);

        return Result.ok(page);

    }
    //TODO 添加业务还未实现

    @DeleteMapping("/deleteChangeJobById/{id}")
    public Result deleteChangeJobById(@PathVariable Integer id){
        boolean flag = changeJobService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


}
