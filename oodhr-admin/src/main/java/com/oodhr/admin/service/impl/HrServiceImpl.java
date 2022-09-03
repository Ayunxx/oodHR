package com.oodhr.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.mapper.HrMapper;
import com.oodhr.admin.service.HrService;
import com.oodhr.admin.utils.JwtUtil;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @auther Ayun
 * @date 2022/8/17 12:25
 */
@Service("hrService")
public class HrServiceImpl extends ServiceImpl<HrMapper, HrEntity> implements HrService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HrMapper hrMapper;



    @Override
    public Map<String, String> verify(HrVo user) {
        //AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //如果认证不通过，给出对应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //认证通过则生成一个token
        HrVo hrVo = (HrVo) authenticate.getPrincipal();
        String id = hrVo.getId().toString();
        String username = hrVo.getUsername();
        String token = JwtUtil.sign(username, id);

        Map<String, String> mapToken = new HashMap<>();
        mapToken.put("token",token);
        //把完整信息存入redis userid作为key
        redisTemplate.opsForValue().set("tokenId:"+id,hrVo);

        return mapToken;
    }

    @Override
    public void logout() {
        //获取securityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        HrVo hrVo = (HrVo) authentication.getPrincipal();
        Integer id = hrVo.getId();
        //删除redis中的值
        redisTemplate.delete("tokenId:"+id);

    }

    /**
     * 加密加盐
     * @param hrEntity
     * @return
     */
    @Override
    public HrEntity encryption(HrEntity hrEntity) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean flag = false;
        String password = hrEntity.getPassword();
        String encode = passwordEncoder.encode(password);
        hrEntity.setPassword(encode);
        return hrEntity;
    }

    @Override
    public List<HrVo> getUserList() {
        List<HrVo> userList = hrMapper.getUserList();
        return userList;
    }
}
