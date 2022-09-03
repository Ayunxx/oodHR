package com.oodhr.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oodhr.admin.entity.RandPEntity;
import com.oodhr.admin.entity.TrainEntity;
import com.oodhr.admin.service.RandPService;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.RandPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @auther Ayun
 * @date 2022/8/19 16:59
 */
@RestController
@RequestMapping("/RandP")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:RandP')")
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
    @PreAuthorize("hasAnyAuthority('system:RandP:list','system:RandP')")
    @PostMapping("/getListPage/{current}/{size}")
    public Result getListPage(@PathVariable Long current,
                              @PathVariable Long size,
                              @RequestBody RandPVo randPVo){

        IPage<RandPVo> page = randPService.getPage(current, size, randPVo);

        return Result.ok(page);
    }
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getRandPById/{id}")
    public Result getRandPById(@PathVariable Integer id) {
        RandPEntity randPServiceById = randPService.getById(id);

        return Result.ok(randPServiceById);
    }

    /**
     * 添加
     * @param randPEntity
     * @return
     */
    @PostMapping("/addRandP")
    public Result addRandP(@RequestBody RandPEntity randPEntity){

        boolean flag = randPService.save(randPEntity);

        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改更新
     * @param randPEntity
     * @return
     */
    @PostMapping("/updateRandP")
    public Result updateRandP(@RequestBody RandPEntity randPEntity){
        boolean flag = randPService.updateById(randPEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRandPById/{id}")
    public Result deleteRandPById(@PathVariable Integer id){

        boolean flag = randPService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
