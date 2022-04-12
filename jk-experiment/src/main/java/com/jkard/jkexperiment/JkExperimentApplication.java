package com.jkard.jkexperiment;


import com.jkard.jkexperiment.common.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JkExperimentApplication {

    // 定义切面（使用注解@Bean注入到Spring IOC）
    @Bean(name="myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }


    public static void main(String[] args) {
        SpringApplication.run(JkExperimentApplication.class, args);
    }

}
