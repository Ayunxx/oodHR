package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.vo.HrVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HrMapper extends BaseMapper<HrEntity> {
    HrEntity verify(HrVo user);
}
