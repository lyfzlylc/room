package com.wangyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
//@MapperScan(basePackages = "com.wangyue.mapper")
public class HosueApplication {

    public static void main(String[] args) {
        SpringApplication.run(HosueApplication.class, args);
    }

}
