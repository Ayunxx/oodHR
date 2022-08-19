package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.ChangeJobEntity;
import com.oodhr.admin.vo.ChangeJobVo;

/**
 * @auther Ayun
 * @date 2022/8/19 20:23
 */
public interface ChangeJobService extends IService<ChangeJobEntity> {
    IPage<ChangeJobVo> getPage(Long current, Long size, ChangeJobVo changeJobVo);
}
