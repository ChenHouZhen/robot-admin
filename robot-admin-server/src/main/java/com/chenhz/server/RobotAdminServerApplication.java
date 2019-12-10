package com.chenhz.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenhz.mapper")
public class RobotAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotAdminServerApplication.class, args);
    }

}
