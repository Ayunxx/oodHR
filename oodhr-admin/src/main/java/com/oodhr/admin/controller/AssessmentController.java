package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.entity.AssessmentEntity;
import com.oodhr.admin.entity.RandPEntity;
import com.oodhr.admin.service.AssessmentService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.AssessmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @auther Ayun
 * @date 2022/8/19 19:14
 */
@RestController
@RequestMapping("/assessment")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:assessment')")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;


    @PreAuthorize("hasAnyAuthority('system:assessment:list','system:assessment')")
    @PostMapping("/getAssessmentList/{current}/{size}")
    public Result getAssessmentList(@PathVariable Long current,
                                    @PathVariable Long size,
                                    @RequestBody AssessmentVo assessmentVo){
        IPage<AssessmentVo> page = assessmentService.getPage(current, size, assessmentVo);

        return Result.ok(page);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getAssessmentById/{id}")
    public Result getAssessmentById(@PathVariable Integer id) {
        AssessmentEntity assessmentServiceById = assessmentService.getById(id);

        return Result.ok(assessmentServiceById);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAssessmentById/{id}")
    public Result deleteAssessmentById(@PathVariable Integer id){
        boolean flag = assessmentService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 添加
     * @param assessmentEntity
     * @return
     */
    @PostMapping("/addAssessment")
    public Result addAssessment(@RequestBody AssessmentEntity assessmentEntity){
        System.out.println(assessmentEntity.toString());
        boolean flag = assessmentService.save(assessmentEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改
     * @param assessmentEntity
     * @return
     */
    @PostMapping("/updateAssessment")
    public Result updateAssessment(@RequestBody AssessmentEntity assessmentEntity){
        boolean flag = assessmentService.updateById(assessmentEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}

