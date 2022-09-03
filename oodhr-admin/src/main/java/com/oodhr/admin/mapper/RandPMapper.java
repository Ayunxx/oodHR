package com.oodhr.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.entity.RandPEntity;
import com.oodhr.admin.vo.RandPVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther Ayun
 * @date 2022/8/19 17:00
 */
@Mapper
public interface RandPMapper extends BaseMapper<RandPEntity> {

    @Select("select rap.*,e.emp_name,e.workID " +
            "from emp_rewardandpunish rap " +
            "left join employee e " +
            "on e.id = rap.eid "+
            "where rap.del_flag = 0 "+
            "${ew.customSqlSegment}")
    IPage<RandPVo> getListPage(Page<RandPVo> randPVoPage, @Param(Constants.WRAPPER) QueryWrapper<RandPVo> queryWrapper);
}
