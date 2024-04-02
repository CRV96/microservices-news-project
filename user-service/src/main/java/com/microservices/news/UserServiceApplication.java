package com.microservices.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaAuditing
public class NewsServiceApplication {
    public static void main(String []args){
        SpringApplication.run(NewsServiceApplication.class, args);
    }

}
