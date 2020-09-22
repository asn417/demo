package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0;i<100;i++){
                logger.info("---test---"+i);
            }
        }).start();
        SpringApplication.run(DemoApplication.class, args);
    }
}
