package com.example.demo.Filter;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtil;
import com.example.demo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private JwtTokenUtil jwtTokenUtil;
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Value(value="${authHeaderJWT}")
    private String authHeader;
    @Value(value="${authHeadJWT}")
    private String authHead;
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader =request.getHeader(this.authHeader);
        if (authHeader!=null){
            //获取用户名
            String username=jwtTokenUtil.getUserIdFromToken(authHeader);
            log.info("check userId:{}",username);
            //用户校验
            if (username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
                //去数据库查询username，并加载
                    UserDetails userDetails=userService.hasUser(username);
                if (jwtTokenUtil.validateToken(authHeader,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    log.info("authenticated user:{}",username);
                    //设置用户授权
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
