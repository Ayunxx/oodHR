package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.AssessmentEntity;
import com.oodhr.admin.vo.AssessmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther Ayun
 * @date 2022/8/19 19:21
 */
@Mapper
public interface AssessmentMapper extends BaseMapper<AssessmentEntity> {

    @Select("select ass.*,e.emp_name,e.workID " +
            "from emp_assessment ass " +
            "left join employee e " +
            "on e.id = ass.eid " +
            "${ew.customSqlSegment}")
    IPage<AssessmentVo> getListPage(Page<AssessmentVo> page,
                                    @Param(Constants.WRAPPER) QueryWrapper<AssessmentVo> queryWrapper);
}
