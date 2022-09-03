package com.oodhr.admin.handler;


import com.alibaba.fastjson.JSON;
import com.oodhr.admin.utils.WebUtil;
import com.oodhr.admin.utils.result.Result;
import com.oodhr.admin.utils.result.ResultCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther Ayun
 * @date 2022/8/29 12:02
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //自定义异常
        Result<Object> result = new Result<>().code(HttpStatus.UNAUTHORIZED.value()).message("登录异常认证失败");
        String json = JSON.toJSONString(result);
        WebUtil.renderString(response,json);
    }
}
