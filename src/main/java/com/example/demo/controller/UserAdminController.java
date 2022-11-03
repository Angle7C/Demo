package com.example.demo.controller;

import com.example.demo.entity.model.JsonResult;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "AdminController")
@Setter(onMethod_ = {@Autowired})
public class UserAdminController {

    private UserService userService;
    @PostMapping("/login/{username}/{password}")
    public JsonResult login(@PathVariable String username,@PathVariable String password){
        String token=userService.login(username,password);
        return JsonResult.success();
    }
}
