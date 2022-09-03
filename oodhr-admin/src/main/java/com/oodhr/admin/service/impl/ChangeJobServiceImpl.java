package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.ChangeJobEntity;
import com.oodhr.admin.mapper.ChangeJobMapper;
import com.oodhr.admin.service.ChangeJobService;
import com.oodhr.admin.vo.ChangeJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther Ayun
 * @date 2022/8/19 20:24
 */
@Service("changeJobService")
public class ChangeJobServiceImpl extends ServiceImpl<ChangeJobMapper, ChangeJobEntity> implements ChangeJobService {

    @Autowired
    private ChangeJobMapper changeJobMapper;
    @Override
    public IPage<ChangeJobVo> getPage(Long current, Long size, ChangeJobVo changeJobVo) {
        Page<ChangeJobVo> jobVoPage = new Page<>(current,size);
        QueryWrapper<ChangeJobVo> queryWrapper = new QueryWrapper<>();
        //TODO 模糊业务


        IPage<ChangeJobVo> listPage = changeJobMapper.getListPage(jobVoPage, queryWrapper);
        return listPage;
    }
}
