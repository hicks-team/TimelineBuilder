package com.hicks.team;

import com.hicks.team.models.User;
import com.hicks.team.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Setup {

    private UserService m_userService;

    @Autowired
    public Setup(UserService userService) {
        this.m_userService = userService;
    }

    @Bean
    public CommandLineRunner runSetup() {
        return args -> {

            List<User> users = m_userService.getUsers();
            System.out.println(users);
        };
    }

}
