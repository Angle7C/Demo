package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface MinIOService {
    //判断是否存在一个桶
    boolean bucketExists(String bucketName);
    //创建一个桶
    void makeBucket(String bucketName);
    //文件上传
    void putObject(String bucketName,String objectName,String fileName);
    //文件上传
    void putObject(String bucketName, String objectName, InputStream stream, String contentType);
    //文件上传
    void putObject(String bucketName, MultipartFile multipartFile, String filename);
    //删除文件
    boolean removeObject(String bucketName,String filePath);
    //获取Url
    String getObjectUrl(String bucketName,String objectName);


}
