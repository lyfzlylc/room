package com.wangyue;
//@MapperScan("com.wangyue.mapper")

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@MapperScan(basePackages = "com.wangyue.mapper")
public class HosueApplication {

    public static void main(String[] args) {

        SpringApplication.run(HosueApplication.class, args);
    }

}
