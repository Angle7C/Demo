package com.example.demo.component;

import cn.hutool.json.JSONUtil;
import com.example.demo.entity.model.EnumResult;
import com.example.demo.entity.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  用户没有登录授权的Json数据
 */
@Component
@Slf4j
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter()
                .println(JSONUtil
                        .parse(JsonResult.success(EnumResult.NONE_AUTH)));
        response.getWriter().flush();
    }
}
