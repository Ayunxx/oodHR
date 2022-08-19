package com.oodhr.admin.controller;

import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.service.HrService;
import com.oodhr.admin.utils.JwtUtil;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Ayun
 * @date 2022/8/17 12:25
 */
@RestController
@CrossOrigin
public class HrController {

    @Autowired
    private HrService hrService;

    @PostMapping("/hr/login")
    public Result login(@RequestBody HrVo user){

            //调用UserService完成username和password的验证
        HrEntity hr = hrService.verify(user);
        System.out.println();
            //根据验证结果，组成响应对象返回
            if (hr != null){
                //创建一个token数据，封装到对象中
                String token = JwtUtil.sign(hr.getUsername(),"-1");
                TokenVo tokenVo = new TokenVo(token);
                System.out.println(tokenVo);
                return Result.ok(tokenVo);
            } else {
                return Result.fail("失败");
            }
    }
}
