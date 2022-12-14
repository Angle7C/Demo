package com.example.demo.config;

import com.example.demo.Filter.JwtAuthenticationTokenFilter;
import com.example.demo.component.RestAuthenticationEntryPoint;
import com.example.demo.component.RestfulAccessDeniedHandler;
import org.apache.catalina.filters.CorsFilter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.Filter;
@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Value("${authHeaderJWT}")
    private String authHeader;

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
//  ??????????????????????????????options
                    .antMatchers(HttpMethod.OPTIONS)
                    .permitAll()
                    .antMatchers("/login/**")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/Admin/**")
                    .hasRole("Admin")
                    .anyRequest()
                    .permitAll();
//            ????????????
            httpSecurity.headers().cacheControl();
//            ????????????JWT?????????
            httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.exceptionHandling()
                    .accessDeniedHandler(restfulAccessDeniedHandler)
                    .authenticationEntryPoint(restAuthenticationEntryPoint);
        return  httpSecurity.build();
    }
    @Bean
    public WebMvcConfigurer corsFilter(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(false)
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*")
                        .exposedHeaders(authHeader);
            }
        };
    }
}
