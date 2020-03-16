package com.hicks.team.controllers;

import com.hicks.team.models.User;
import com.hicks.team.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService m_userService;

    @Autowired
    public UserController(UserService userService) {
        this.m_userService = userService;
    }

    @GetMapping
    public User getUser(@RequestParam("id") String id) {
        return m_userService.getUser(() -> Long.parseLong(id));
    }

}
