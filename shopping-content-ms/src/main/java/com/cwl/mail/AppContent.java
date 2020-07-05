package com.cwl.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cwl.mail.mapper")
public class AppContent {
    public static void main(String[] args) {
        SpringApplication.run(AppContent.class,args);
    }
}
