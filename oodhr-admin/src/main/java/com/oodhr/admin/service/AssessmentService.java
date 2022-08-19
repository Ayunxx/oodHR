package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.AssessmentEntity;
import com.oodhr.admin.vo.AssessmentVo;

/**
 * @auther Ayun
 * @date 2022/8/19 19:22
 */
public interface AssessmentService extends IService<AssessmentEntity> {
    IPage<AssessmentVo> getPage(Long current, Long size, AssessmentVo assessmentVo);
}
