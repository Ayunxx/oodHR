package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.service.TrainService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.TrainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther Ayun
 * @date 2022/8/19 12:15
 */
@RestController
@RequestMapping("/train")
@CrossOrigin
public class TrainController {

    @Autowired
    private TrainService trainService;


    /**
     * 获取全部培训记录
     * @return
     */
    @PostMapping("/getTrainList/{current}/{size}")
    public Result getTrainList(@PathVariable Long current,
                               @PathVariable Long size,
                               @RequestBody TrainVo trainVo

    ){

        IPage<TrainVo> pageList = trainService.getPageList(current, size,trainVo);


        return Result.ok(pageList);
    }




}
