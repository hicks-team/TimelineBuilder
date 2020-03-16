package com.hicks.team.repositories;

import com.hicks.team.models.Event;
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
        data.put("users", createUsers());
        data.put("events", createEvents());
    }

    /*
    User methods
     */
    public List<User> getUsers() {
        return (List<User>) data.get("users");
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

    /**
     * Event methods
     */

    public List<Event> getUserEvents() {
        return (List<Event>) data.get("events");
    }

    private List<Event> createEvents() {
        Event event1 = new Event("", 1, "Summer Vacation", "", LocalDate.of(2014, 8, 15), LocalDate.of(2014, 8, 31), null);
        Event event2 = new Event("", 1, "Short Vacation", "", LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), null);
        Event event3 = new Event("", 1, "Birthday", "", LocalDate.of(1986, 1, 1), LocalDate.of(1986, 1, 1), null);
        Event event4 = new Event("", 1, "Puperino", "", LocalDate.of(2008, 4, 16), LocalDate.of(2014, 04, 19), null);
        Event event5 = new Event("", 1, "Boo Cat", "", LocalDate.of(2005, 4, 25), LocalDate.of(2011, 05, 19), null);
        Event event6 = new Event("", 1, "High School", "", LocalDate.of(2001, 04, 25), LocalDate.of(2005, 05, 19), null);
        Event event7 = new Event("", 1, "College", "", LocalDate.of(2006, 04, 25), LocalDate.of(2010, 05, 19), null);
        Event event8 = new Event("", 1, "Second Job", "", LocalDate.of(2012, 04, 25), LocalDate.of(2018, 05, 19), null);
        Event event9 = new Event("", 1, "First Job", "", LocalDate.of(2008, 04, 25), LocalDate.of(2010, 05, 19), null);
        Event event10 = new Event("", 1, "Client Meeting in Sacramento", "", LocalDate.of(2017, 03, 15), LocalDate.of(2017, 03, 20), null);
        Event event11 = new Event("", 1, "Pupperino 2", "", LocalDate.of(2020, 04, 19), LocalDate.of(2020, 04, 19), null);
        Event event12 = new Event("", 1, "Cat 2", "", LocalDate.of(2019, 05, 19), LocalDate.of(2019, 05, 19), null);
        Event event13 = new Event("", 1, "Get Passport", "", LocalDate.of(2007, 8, 25), LocalDate.of(2007, 8, 25), null);

        return List.of(event1, event2, event3, event4, event5, event6,
                event7, event8, event9, event10, event11,
                event12, event13);
    }
}
