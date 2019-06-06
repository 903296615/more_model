package com.mmabj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.mmabj.common")
@ComponentScan(value = "com.mmabj.merchant")
@SpringBootApplication
public class MerchantApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerchantApplication.class,args);
    }
}
