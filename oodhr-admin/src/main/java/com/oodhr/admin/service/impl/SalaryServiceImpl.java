package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.SalaryEntity;
import com.oodhr.admin.mapper.SalaryMapper;
import com.oodhr.admin.service.SalaryService;
import com.oodhr.admin.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/21 19:10
 */
@Service("salaryService")
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, SalaryEntity> implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public IPage<SalaryVo> getPage(Long current, Long size, SalaryVo vo) {

        Page<SalaryVo> voPage = new Page<>(current,size);
        QueryWrapper<SalaryVo> voQueryWrapper = new QueryWrapper<>();



        IPage<SalaryVo> listPage = salaryMapper.getListPage(voPage, voQueryWrapper);
        return listPage;
    }

    @Override
    public SalaryVo getSalaryById(Integer id) {
        SalaryVo byId = salaryMapper.getById(id);
        return byId;
    }
}
