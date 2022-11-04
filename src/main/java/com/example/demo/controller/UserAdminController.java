package com.example.demo.controller;

import com.example.demo.entity.model.JsonResult;
import com.example.demo.entity.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/selectuser/{userId}")
    public JsonResult selectUser(@PathVariable String userId){
        User user=userService.selectUser(userId);
        JsonResult jsonResult=new JsonResult<>();
        jsonResult.setContext(user);
        jsonResult.setContext(JsonResult.success());
        return  jsonResult;
    }

    @PostMapping("/adduser")
    public JsonResult addUser(@ModelAttribute User user){
        userService.addUser(user);
        return JsonResult.success();
    }

    @PutMapping("/updateuser")
    public JsonResult updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        User user1=userService.selectUser(user.getUserId());
        JsonResult jsonResult=new JsonResult<>();
        jsonResult.setContext(user1);
        jsonResult.setContext(JsonResult.success());
        return  jsonResult;
    }

    @DeleteMapping("/removeUser/{userId}")
    public JsonResult removeUser(@PathVariable String userId){
        userService.removeUser(userId);
        return JsonResult.success();
    }


}
