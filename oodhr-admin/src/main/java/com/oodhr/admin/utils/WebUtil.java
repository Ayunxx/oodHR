package com.oodhr.admin.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther Ayun
 * @date 2022/8/29 12:06
 */
public class WebUtil {

    public static String renderString(HttpServletResponse response,String str){

        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
