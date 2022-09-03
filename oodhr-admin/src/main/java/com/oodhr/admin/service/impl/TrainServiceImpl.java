package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.TrainEntity;
import com.oodhr.admin.mapper.TrainMapper;
import com.oodhr.admin.service.TrainService;
import com.oodhr.admin.vo.TrainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/19 12:19
 */
@Service("trainService")
public class TrainServiceImpl extends ServiceImpl<TrainMapper, TrainEntity> implements TrainService {

    @Autowired
    private TrainMapper trainMapper;


    @Override
    public IPage<TrainVo> getPageList(Long current, Long size, TrainVo trainVo) {

        Page<TrainVo> trainVoPage = new Page<>(current,size);

        QueryWrapper<TrainVo> queryWrapper = new QueryWrapper<>();
        //TODO 具体模糊查询业务


        IPage<TrainVo> page = trainMapper.getPage(trainVoPage,queryWrapper);

        return page;
    }
}
