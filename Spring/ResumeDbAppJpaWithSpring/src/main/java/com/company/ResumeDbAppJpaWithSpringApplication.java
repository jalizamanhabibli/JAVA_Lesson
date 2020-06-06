package com.company;

import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaWithSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ResumeDbAppJpaWithSpringApplication.class, args);
        UserServiceInter userServiceInter =(UserServiceInter) context.getBean("userServiceImplData");
        User user = userServiceInter.getById(1);
        System.out.println(user);
    }

}
