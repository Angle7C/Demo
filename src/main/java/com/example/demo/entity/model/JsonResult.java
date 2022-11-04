package com.example.demo.entity.model;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class JsonResult<T> {

    public static final int SUCESS=0;

    private int state;
    private String message="";
    private T data;
    private List<T> datas;
//	private PageInfo<T> pagedatas;
//	private long total;
//	private List<T> rows;


    public JsonResult(String message) {
        this.state=SUCESS;
        this.message=message;
    }

    public JsonResult(int state,String message) {
        this.state=state;
        this.message=message;
    }

    public JsonResult(T data) {
        this.state=SUCESS;
        this.data=data;
    }

    public JsonResult(String message,T data) {
        this.state=SUCESS;
        this.message=message;
        this.data=data;
    }

    public JsonResult(int state,String message,T data) {
        this.state=state;
        this.message=message;
        this.data=data;
    }

    public JsonResult(List<T> datas) {
        this.state=SUCESS;
        this.datas=datas;
    }

    public JsonResult(String message,List<T> datas) {
        this.state=SUCESS;
        this.message=message;
        this.datas=datas;
    }

    public JsonResult(int state,String message,List<T> datas) {
        this.state=state;
        this.message=message;
        this.datas=datas;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }











}
