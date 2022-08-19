package com.oodhr.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.vo.HrVo;

public interface HrService extends IService<HrEntity> {
    HrEntity verify(HrVo user);
}
