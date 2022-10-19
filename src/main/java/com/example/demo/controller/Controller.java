package com.example.demo.controller;

import com.example.demo.entity.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
