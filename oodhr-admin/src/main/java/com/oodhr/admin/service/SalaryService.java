package com.oodhr.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.SalaryEntity;
import com.oodhr.admin.vo.SalaryVo;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/21 19:09
 */
public interface SalaryService extends IService<SalaryEntity> {


    /**
     * 条件查询并分页
     * @param current
     * @param size
     * @param vo
     * @return
     */
    IPage<SalaryVo> getPage(Long current, Long size, SalaryVo vo);

    SalaryVo getSalaryById(Integer id);
}
