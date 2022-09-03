package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.ChangeSalaryEntity;
import com.oodhr.admin.vo.ChangeSalaryVo;

/**
 * @auther Ayun
 * @date 2022/8/22 11:25
 */

public interface ChangeSalaryService extends IService<ChangeSalaryEntity> {
    IPage<ChangeSalaryVo> getListPage(Long current, Long size, ChangeSalaryVo changeSalaryVo);
}
