package com.example.paris20224;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import service.SportService;
import service.SportServiceImpl;

@SpringBootApplication
public class Paris20224Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Paris20224Application.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/sports/overview");
    }

    @Bean
    SportService sportService() { return new SportServiceImpl(); }
}
