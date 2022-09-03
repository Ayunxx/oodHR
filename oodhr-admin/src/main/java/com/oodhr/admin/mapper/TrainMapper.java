package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.EmployeeEntity;
import com.oodhr.admin.entity.TrainEntity;
import com.oodhr.admin.vo.RandPVo;
import com.oodhr.admin.vo.TrainVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/19 12:16
 */
@Mapper
public interface TrainMapper extends BaseMapper<TrainEntity> {

    @Select("select et.*,e.emp_name,e.workid " +
            "from emp_train et " +
            "left join employee e " +
            "on e.id = et.eid "+
            "where et.del_flag = 0 " +
            "${ew.customSqlSegment}")
    IPage<TrainVo> getPage(Page<TrainVo> page ,@Param(Constants.WRAPPER) QueryWrapper<TrainVo> queryWrapper);

}
