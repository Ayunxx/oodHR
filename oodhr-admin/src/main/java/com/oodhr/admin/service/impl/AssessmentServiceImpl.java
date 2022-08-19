package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.AssessmentEntity;
import com.oodhr.admin.mapper.AssessmentMapper;
import com.oodhr.admin.service.AssessmentService;
import com.oodhr.admin.vo.AssessmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther Ayun
 * @date 2022/8/19 19:22
 */
@Service("assessmentService")
public class AssessmentServiceImpl extends ServiceImpl<AssessmentMapper,AssessmentEntity> implements AssessmentService{

    @Autowired
    private AssessmentMapper assessmentMapper;

    @Override
    public IPage<AssessmentVo> getPage(Long current, Long size, AssessmentVo assessmentVo) {
        Page<AssessmentVo> voPage = new Page<>(current, size);
        QueryWrapper<AssessmentVo> queryWrapper = new QueryWrapper<>();


        IPage<AssessmentVo> listPage = assessmentMapper.getListPage(voPage, queryWrapper);


        return listPage;
    }
}
