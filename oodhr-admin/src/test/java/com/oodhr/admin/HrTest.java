package com.oodhr.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oodhr.admin.mapper.HrMapper;
import com.oodhr.admin.mapper.MenuMapper;
import com.oodhr.admin.utils.JwtUtil;
import com.oodhr.admin.vo.HrVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/24 14:27
 */
@SpringBootTest
public class HrTest {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void Test(){
        String username = "张三";
        QueryWrapper<HrVo> voQueryWrapper = new QueryWrapper<>();
        voQueryWrapper.eq("username",username);
        HrVo oneByUsername = hrMapper.getOneByUsername(voQueryWrapper);
        System.out.println(oneByUsername.toString());
    }


    @Test
    void passwordTest(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);

    }


    @Test
    void testToken(){
        String verity = JwtUtil.verity("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dpbk5hbWUiOiJhZG1pbiIsImV4cCI6MTY2MTQ4MDM4OCwidXNlcklkIjoiMSJ9.sthmRkZHnqcdQlw58OvhQY4gxjkzTn9BPigAlDxWuMQ");
        System.out.println(verity);
    }

    @Test
    void testPaemrs(){
        List<String> list = menuMapper.selectPermsByHrId(1);
        System.out.println(list);
    }
}
