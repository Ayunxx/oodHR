package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.RandPEntity;
import com.oodhr.admin.mapper.RandPMapper;
import com.oodhr.admin.service.RandPService;
import com.oodhr.admin.vo.RandPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther Ayun
 * @date 2022/8/19 17:01
 */
@Service("randPService")
public class RandPServiceImpl extends ServiceImpl<RandPMapper, RandPEntity> implements RandPService {

    @Autowired
    private RandPMapper randPMapper;

    @Override
    public IPage<RandPVo> getPage(Long current, Long size, RandPVo randPVo) {
        Page<RandPVo> randPVoPage = new Page<>(current,size);
        QueryWrapper<RandPVo> queryWrapper = new QueryWrapper<>();

        /*if (!randPVo.equals(null)){
            String workId = randPVo.getWorkId();
            String name = randPVo.getEmpName();
            if (StringUtils.hasText(workId)){
                queryWrapper.like("workid",workId);
            }
            if (StringUtils.hasText(name)){
                queryWrapper.like("empname",name);
            }
        }*/

        IPage<RandPVo> listPage = randPMapper.getListPage(randPVoPage, queryWrapper);
        return listPage;
    }
}
