package com.example.demo.controller;

import com.example.demo.entity.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test")
@RestController
public class Controller {
    @ApiOperation("hello world")
    @GetMapping("/hello")
//    @ResponseBody
    public String hello(User user){
        return "hello world";
    }

    @GetMapping("/into")
    @ApiOperation("in to")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public String hellos(User user){
        return "hello world";
    }
    @GetMapping("/login")
    public String login(User user){
        System.out.println("spring security use login");return null;
    }
}
