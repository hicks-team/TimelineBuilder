package com.hicks.team.repositories;

import com.hicks.team.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MockDatabase {

    private Map<String, List<? extends Object>> data;

    public MockDatabase(){
        data = new HashMap<>();
        data.put("user", createUsers());
    }


/*
User methods
 */
    public List<User> getUsers() {
        return (List<User>) data.get("user");
    }

    private List<User> createUsers() {
        User steve = new User();
        steve.setEmail("shicks@yahoo.com");
        steve.setDisplayName("shicks");
        steve.setDob(LocalDate.of(1989, 4, 25));
        steve.setId(1);

        User eric = new User();
        eric.setEmail("ehicks@yahoo.com");
        eric.setDisplayName("ehicks");
        eric.setDob(LocalDate.of(1987, 7, 21));
        eric.setId(2);

        return List.of(steve, eric);
    }

}
