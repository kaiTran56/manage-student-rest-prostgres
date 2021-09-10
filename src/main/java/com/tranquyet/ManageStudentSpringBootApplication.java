package com.tranquyet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ManageStudentSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageStudentSpringBootApplication.class, args);
    }

}
