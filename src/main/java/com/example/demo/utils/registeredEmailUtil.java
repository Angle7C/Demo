package com.example.demo.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class registeredEmailUtil {
    private static final String symbols="01234564789ADBCGPOLKJ";
    private static final Random random=new SecureRandom();
    public static boolean registerCode(String to){
        String code=getCode();
        String ans= MailUtil.send(to, "验证码测试", code, false);
        return ;
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
