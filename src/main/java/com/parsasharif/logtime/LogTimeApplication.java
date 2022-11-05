package com.parsasharif.logtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LogTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogTimeApplication.class, args);
    }

}
