package com.example.demo.service.impl;

import com.example.demo.service.MinIOService;
import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
@Service
@Slf4j
public class MinIOServiceImpl implements MinIOService {
    @Autowired
    private MinioClient minioClient;
    @Override
    public boolean bucketExists(String bucketName) throws RuntimeException{
        BucketExistsArgs bucketExistsArgs= BucketExistsArgs.builder().bucket(bucketName).build();
        try {
            return minioClient.bucketExists(bucketExistsArgs);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void makeBucket(String bucketName) {

    }

    @Override
    public void putObject(String bucketName, String objectName, String fileName) {

    }

    @Override
    public void putObject(String bucketName, String objectName, InputStream stream, String contentType) {

    }

    @Override
    public void putObject(String bucketName, MultipartFile multipartFile, String filename) {

    }

    @Override
    public boolean removeObject(String bucketName, String filePath) {
        return false;
    }

    @Override
    public String getObjectUrl(String bucketName, String objectName) {
        return null;
    }
}
