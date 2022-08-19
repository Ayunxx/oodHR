package com.oodhr.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oodhr.admin.mapper.TrainMapper;
import com.oodhr.admin.service.TrainService;
import com.oodhr.admin.vo.TokenVo;
import com.oodhr.admin.vo.TrainVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/19 12:55
 */

@SpringBootTest
class TrainTest {
    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private TrainService trainService;

    @Test
    void TestTRPage(){
        Page<TrainVo> trainVoPage = new Page<>();
        trainVoPage.setCurrent(1);
        trainVoPage.setSize(3);
        TrainVo trainVo = new TrainVo();
        IPage<TrainVo> pageList = trainService.getPageList(1L, 3L,trainVo);

        List<TrainVo> records = pageList.getRecords();
        records.forEach(System.out::println);


    }
}
