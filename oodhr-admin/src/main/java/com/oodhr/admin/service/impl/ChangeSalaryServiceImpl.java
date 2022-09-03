package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.ChangeSalaryEntity;
import com.oodhr.admin.mapper.ChangeSalaryMapper;
import com.oodhr.admin.service.ChangeSalaryService;
import com.oodhr.admin.vo.ChangeSalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther Ayun
 * @date 2022/8/22 11:25
 */
@Service("changeSalaryService")
public class ChangeSalaryServiceImpl
        extends ServiceImpl<ChangeSalaryMapper, ChangeSalaryEntity>
        implements ChangeSalaryService {

    @Autowired
    private ChangeSalaryMapper changeSalaryMapper;

    @Override
    public IPage<ChangeSalaryVo> getListPage(Long current, Long size, ChangeSalaryVo changeSalaryVo) {
        Page<ChangeSalaryVo> voPage = new Page<>(current, size);
        QueryWrapper<ChangeSalaryVo> queryWrapper = new QueryWrapper<>();


        IPage<ChangeSalaryVo> page = changeSalaryMapper.getPage(voPage, queryWrapper);

        return page;
    }
}
