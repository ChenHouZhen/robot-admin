package com.chenhz.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement

// mybatis plus 扫描

@MapperScan("com.chenhz.server.mapper")

@SpringBootApplication
public class RobotAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotAdminServerApplication.class, args);
    }

}
