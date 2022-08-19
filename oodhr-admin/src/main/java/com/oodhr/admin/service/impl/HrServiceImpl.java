package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.mapper.HrMapper;
import com.oodhr.admin.service.HrService;
import com.oodhr.admin.vo.HrVo;
import org.springframework.stereotype.Service;

/**
 * @auther Ayun
 * @date 2022/8/17 12:25
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, HrEntity> implements HrService {
    @Override
    public HrEntity verify(HrVo user) {
        HrEntity verifyuser = baseMapper.verify(user);


        return verifyuser;
    }
}
