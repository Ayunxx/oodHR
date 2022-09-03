package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oodhr.admin.mapper.HrMapper;
import com.oodhr.admin.mapper.MenuMapper;
import com.oodhr.admin.vo.HrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @auther Ayun
 * @date 2022/8/24 14:15
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        QueryWrapper<HrVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        HrVo hrVo = hrMapper.getOneByUsername(queryWrapper);
        if (Objects.isNull(hrVo)) {
            throw new RuntimeException("用户名或密码错误");
        }
        List<String> list = menuMapper.selectPermsByHrId(hrVo.getId());
        hrVo.setRoles(list);

        //把数据封装成UserDetails
        return hrVo;
    }
}
