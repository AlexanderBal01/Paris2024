package com.example.paris20224;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import service.MyUserDetailService;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain")
public class Paris20224Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Paris20224Application.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/sports/overview");
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    UserDetailsService myUserDetailsService() { return new MyUserDetailService();}
}
