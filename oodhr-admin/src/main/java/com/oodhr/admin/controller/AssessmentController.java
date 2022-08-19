package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.service.AssessmentService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.AssessmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther Ayun
 * @date 2022/8/19 19:14
 */
@RestController
@RequestMapping("/assessment")
@CrossOrigin
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/getAssessmentList/{current}/{size}")
    public Result getAssessmentList(@PathVariable Long current,
                                    @PathVariable Long size,
                                    @RequestBody AssessmentVo assessmentVo){
        IPage<AssessmentVo> page = assessmentService.getPage(current, size, assessmentVo);

        return Result.ok(page);
    }

}
