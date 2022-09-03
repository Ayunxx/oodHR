package com.oodhr.admin.controller;

import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.service.HrService;
import com.oodhr.admin.utils.JwtUtil;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @auther Ayun
 * @date 2022/8/17 12:25
 */
@RestController
@CrossOrigin
public class HrController {

    @Autowired
    private HrService hrService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @PostMapping("/hr/login")
    public Result login(@RequestBody HrVo user){

            //调用UserService完成username和password的验证
        Map<String, String> token = hrService.verify(user);

        return Result.ok(token);
    }

    @GetMapping("/hr/info")
    public Result info(@RequestParam String token){
        String verity;
        //解析token
        try {
            verity = JwtUtil.verity(token);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //从redis中获取用户信息
        String redisKey = "tokenId:" + verity;
        HrVo loginUser = (HrVo) redisTemplate.opsForValue().get(redisKey);
        loginUser.setPassword("");
        return Result.ok(loginUser);
    }

    @GetMapping("/hr/logout")
    public Result logout(){
        hrService.logout();

        return Result.ok("注销成功");
    }
}
