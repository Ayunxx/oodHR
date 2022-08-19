package com.oodhr.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.mapper.RandPMapper;
import com.oodhr.admin.service.RandPService;
import com.oodhr.admin.vo.RandPVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

/**
 * @auther Ayun
 * @date 2022/8/19 18:13
 */
@SpringBootTest
public class RanPTest {

    @Autowired
    private RandPService randPService;

    @Autowired
    private RandPMapper randPMapper;

    @Test
    void Test(){

        Page<RandPVo> randPVoPage = new Page<>();
        randPVoPage.setCurrent(1);
        randPVoPage.setSize(3);
        RandPVo randPVo = new RandPVo();
        randPVo.setEmpName("张三");
        String empName = randPVo.getEmpName();
        QueryWrapper<RandPVo> wrapper = new QueryWrapper<>();
        if (StringUtils.hasText(empName)){
            System.out.println("++++++++++++++++");
            wrapper.like("empName",empName);
        }

        randPMapper.getListPage(randPVoPage,wrapper);
        //randPService.getPage(1L,2L,randPVo);

    }
}
