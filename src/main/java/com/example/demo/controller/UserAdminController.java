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
        return new JsonResult(token);
    }

    @GetMapping("/selectuser/{userId}")
    public JsonResult selectUser(@PathVariable String userId){

        return new JsonResult("查找成功",userService.selectUser(userId));
    }

    @PostMapping("/adduser")
    public JsonResult addUser(@ModelAttribute User user){
        if(userService.addUser(user)){
            return new JsonResult("新增成功");
        }else{
            return new JsonResult("新增失败");
        }

    }

    @PutMapping("/updateuser")
    public JsonResult updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return  new JsonResult("修改成功",userService.selectUser(user.getUserId()));
    }

    @DeleteMapping("/removeUser/{userId}")
    public JsonResult removeUser(@PathVariable String userId){
        userService.removeUser(userId);
        return  new JsonResult("删除成功");
    }


}
