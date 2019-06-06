package com.mmabj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.mmabj.ctable","com.gitee.sunchenbin.mybatis.actable.manager"})
@MapperScan({"com.mmabj.ctable.mapper.**","com.gitee.sunchenbin.mybatis.actable.mapper.**"})
public class ActableDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActableDemoApplication.class, args);
    }
}
