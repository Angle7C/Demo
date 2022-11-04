package com.example.demo.controller;

import com.example.demo.entity.model.EnumResult;
import com.example.demo.entity.model.JsonResult;
import com.example.demo.entity.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.RegisteredEmailUtil;
import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.rmi.registry.Registry;

@RestController("/Admin")
@Api(tags = "AdminController")
@Setter(onMethod_ = {@Autowired})
public class UserAdminController {

    private UserService userService;
    @PostMapping("/login/{username}/{password}")
    public JsonResult<String> login(@PathVariable String username,@PathVariable String password){
        String token=userService.login(username,password);
        return new JsonResult(token);
    }
    @PostMapping("/sendCode/{email}")
    public JsonResult sendCode(@PathVariable("email") String email){
        RegisteredEmailUtil.registerCode(email);
        return JsonResult.success(EnumResult.SUCCESS);
    }
    @PostMapping("/register/{email}/{username}/{code}")
    public JsonResult register(){
            return null;
    }
    @GetMapping("/selectuser/{userId}")
    public JsonResult<User> selectUser(@PathVariable String userId){
        return new JsonResult<>("查找成功",userService.selectUser(userId));
    }
    @PostMapping("/adduser")
    public JsonResult<String> addUser(@ModelAttribute User user){
        if(userService.addUser(user)){
            return new JsonResult<>("新增成功");
        }else{
            return new JsonResult<>("新增失败");
        }

    }
    @PutMapping("/updateuser")
    public JsonResult<User> updateUser(@ModelAttribute User user){
        if(userService.updateUser(user)){
            return  new JsonResult("修改成功",userService.selectUser(user.getUserId()));
        }else{
            return new JsonResult("修改失败");
        }

    }

    @DeleteMapping("/removeUser/{userId}")
    public JsonResult<String> removeUser(@PathVariable String userId){
        if(userService.removeUser(userId)){
            return  new JsonResult("删除成功");
        }else{
            return  new JsonResult("删除失败");
        }

    }


}
