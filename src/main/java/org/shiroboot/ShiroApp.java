package org.shiroboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = "org.shiroboot.mapper")
public class ShiroApp {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApp.class, args);
    }
}