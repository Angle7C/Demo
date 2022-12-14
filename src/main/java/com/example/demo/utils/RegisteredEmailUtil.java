package com.example.demo.utils;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Validator;
import cn.hutool.extra.mail.MailUtil;
import com.example.demo.exception.MyException;
import com.example.demo.exception.enums.ErrorEnums;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class RegisteredEmailUtil {
    private static final String symbols="01234564789ADBCGPOLKJ";
    private static final Random random=new SecureRandom();
    public static boolean registerCode(String to){
        if (Validator.isEmail(to)){
            throw new  MyException(ErrorEnums.CHECK_ERROR.getCode(),"邮箱格式错误");
        }
        String code=getCode();

        String ans= MailUtil.send(to, "验证码测试", code, false);
        RedisUtil.setValue(to,code,10, TimeUnit.MINUTES);
        Assert.isNull(ans,"邮箱发送失败");
        return true;
    }
    public static  String getCode(){
        //生成六位验证码
        char[] codeTemp=new char[6];
        for(int i=0;i<6;i++){
            codeTemp[i]=symbols.charAt(random.nextInt(symbols.length()));
        }
        return new String(codeTemp);
    }
}
