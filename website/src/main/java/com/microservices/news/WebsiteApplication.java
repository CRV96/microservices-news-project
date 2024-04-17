package com.microservices.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.microservices.news.services")
public class WebsiteApplication {
    public static void main(String []args){
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
