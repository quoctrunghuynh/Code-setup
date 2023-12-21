package com.trunghuynh.auth;

import com.trunghuynh.auth.configuration.security.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAuthApplication.class, args);
    }

}
