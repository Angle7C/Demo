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

    //用户登录
    @PostMapping("/login/{username}/{password}")
    public JsonResult<String> login(@PathVariable String username,@PathVariable String password){
        String token=userService.login(username,password);
        return new JsonResult(token);
    }
    //发送Email密匙
    @PostMapping("/sendCode/{email}")
    public JsonResult sendCode(@PathVariable("email") String email){
        RegisteredEmailUtil.registerCode(email);
        return JsonResult.success(EnumResult.SUCCESS);
    }
    //邮箱登录
    @PostMapping("/register/{email}/{username}/{code}")
    public JsonResult register(){
            return null;
    }

    //查找用户
    @GetMapping("/selectuser/{userId}")
    public JsonResult<User> selectUser(@PathVariable String userId){
        return new JsonResult<>("查找成功",userService.selectUser(userId));
    }
    //注册
    @PostMapping("/adduser")
    public JsonResult<String> addUser(@ModelAttribute User user){
        if(userService.addUser(user)){
            return new JsonResult<>("新增成功");
        }else{
            return new JsonResult<>("新增失败");
        }

    }
    //用户更新信息
    @PutMapping("/updateuser")
    public JsonResult<User> updateUser(@ModelAttribute User user){
        if(userService.updateUser(user)){
            return  new JsonResult("修改成功",userService.selectUser(user.getUserId()));
        }else{
            return new JsonResult("修改失败");
        }

    }
    //删除用户
    @DeleteMapping("/removeUser/{userId}")
    public JsonResult<String> removeUser(@PathVariable String userId){
        if(userService.removeUser(userId)){
            return  new JsonResult("删除成功");
        }else{
            return  new JsonResult("删除失败");
        }

    }


}
