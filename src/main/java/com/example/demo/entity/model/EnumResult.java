package com.example.demo.entity.model;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
public enum EnumResult {
    SUCCESS(1000,"请求成功"),
    NONE_LOGIN(2002,"没有登录"),
    NONE_AUTH(2001,"没有权限");
    @JsonValue
    private final Integer code;
    @JsonValue
    private final String message;
    EnumResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
//        String name = name();
        return ":{code:%s,message:%s}".formatted(code,message);
    }
}