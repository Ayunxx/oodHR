package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.entity.ChangeSalaryEntity;
import com.oodhr.admin.service.ChangeSalaryService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.ChangeSalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.zip.InflaterInputStream;

/**
 * @auther Ayun
 * @date 2022/8/22 11:13
 */
@RestController
@RequestMapping("/changeSalary")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:salary')")
public class ChangeSalaryController {

    @Autowired
    private ChangeSalaryService changeSalaryService;



    @PreAuthorize("hasAnyAuthority('system:salary:list','system:salary')")
    @PostMapping("/getChangeSalaryList/{current}/{size}")
    public Result getChangeSalaryList(@PathVariable Long current,
                              @PathVariable Long size,
                              @RequestBody ChangeSalaryVo changeSalaryVo){

        IPage<ChangeSalaryVo> listPage = changeSalaryService.getListPage(current, size, changeSalaryVo);

        return Result.ok(listPage);
    }

}
