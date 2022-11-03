package com.example.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class JsonResult<T> {
    private EnumResult union;
    private T context;
    private Collection<T> collection;
    public static JsonResult success(){
      return new JsonResult(EnumResult.SUCCESS,null,null);
    };
    public static JsonResult failed(EnumResult enumResult){
        return new JsonResult(enumResult,null,null);
    }
}
