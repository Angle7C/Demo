package com.example.demo.config;

import com.example.demo.Filter.JwtAuthenticationTokenFilter;
import com.example.demo.component.RestAuthenticationEntryPoint;
import com.example.demo.component.RestfulAcessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.Filter;
@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Resource
    private RestfulAcessDeniedHandler restfulAcessDeniedHandler;
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

            httpSecurity.csrf()
                    .disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET,
                            "/**/*","/*.html","/favicon.ico","/**/*.html","/**/*.css","/**/*.js","/swagger-resources/**","/v2/api-docs/**")
                    .permitAll()
//  跨域请求会先进行一次options
                    .antMatchers(HttpMethod.OPTIONS)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and();
//            禁用缓存
            httpSecurity.headers().cacheControl();
//            添加一个JWT过滤器
            httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.exceptionHandling()
                    .accessDeniedHandler(restfulAcessDeniedHandler)
                    .authenticationEntryPoint(restAuthenticationEntryPoint);
        return  httpSecurity.build();
    }
}
