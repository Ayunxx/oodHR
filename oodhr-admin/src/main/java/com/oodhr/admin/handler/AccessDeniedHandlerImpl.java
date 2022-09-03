package com.oodhr.admin.handler;

import com.alibaba.fastjson.JSON;
import com.oodhr.admin.utils.WebUtil;
import com.oodhr.admin.utils.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther Ayun
 * @date 2022/8/29 12:31
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //自定义异常
        Result<Object> result = new Result<>().code(HttpStatus.FORBIDDEN.value()).message("权限不足");
        String json = JSON.toJSONString(result);
        WebUtil.renderString(response,json);
    }
}
