package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.service.RandPService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.RandPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther Ayun
 * @date 2022/8/19 16:59
 */
@RestController
@RequestMapping("/RandP")
@CrossOrigin
public class RandPController {

    @Autowired
    private RandPService randPService;

    /**
     * 获取列表并分页返回
     * @param current
     * @param size
     * @param randPVo
     * @return
     */
    @PostMapping("/getListPage/{current}/{size}")
    public Result getListPage(@PathVariable Long current,
                              @PathVariable Long size,
                              @RequestBody RandPVo randPVo){

        IPage<RandPVo> page = randPService.getPage(current, size, randPVo);

        return Result.ok(page);
    }
}
