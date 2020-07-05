package com.cwl.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppSearch {
    public static void main(String[] args) {
        SpringApplication.run(AppSearch.class,args);
    }
}
