package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.TrainEntity;
import com.oodhr.admin.vo.TrainVo;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/19 12:18
 */
public interface TrainService extends IService<TrainEntity> {

    IPage<TrainVo> getPageList(Long current, Long size, TrainVo trainVo);
}
