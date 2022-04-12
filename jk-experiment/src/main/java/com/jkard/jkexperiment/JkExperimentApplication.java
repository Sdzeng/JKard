package com.jkard.jkexperiment;


import com.jkard.jkexperiment.common.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JkExperimentApplication {


    public static void main(String[] args) {
        SpringApplication.run(JkExperimentApplication.class, args);
    }

}
