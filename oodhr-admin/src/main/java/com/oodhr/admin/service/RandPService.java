package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.RandPEntity;
import com.oodhr.admin.vo.RandPVo;

/**
 * @auther Ayun
 * @date 2022/8/19 17:01
 */

public interface RandPService extends IService<RandPEntity> {

    IPage<RandPVo> getPage(Long current, Long size, RandPVo randPVo);
}
