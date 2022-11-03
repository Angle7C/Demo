package com.example.demo.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.mapper")
@Mapper
public class Mybatis {

}
