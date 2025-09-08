package com.easycoding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JavaLearningApplication {

    public static void main(String[] args) {
        log.info("JavaLearningApplication run start");
        SpringApplication.run(JavaLearningApplication.class, args);
        log.info("JavaLearningApplication run end");
    }
}
