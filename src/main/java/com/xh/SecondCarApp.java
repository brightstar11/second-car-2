package com.xh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

//默认springboot会自动扫描启动类的子包孙包,不需要用配置@MapperScan及@ComponentScan
@SpringBootApplication
@ImportResource(locations = { "classpath:druid-bean.xml" })
@EnableAspectJAutoProxy

public class SecondCarApp {
	 
    public static void main(String[] args) {
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(SecondCarApp.class, args);
        System.out.println("启动商城程序成功!正在运行...");
    }
}
