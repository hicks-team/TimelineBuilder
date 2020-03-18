package com.hicks.team.repositories;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
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
        data.put("eventGroups", createEventGroups());
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
        Event event1 = new Event(1, 7, 1, "Summer Vacation", "", LocalDate.of(2014, 8, 15), LocalDate.of(2014, 8, 31), false, null);
        Event event2 = new Event(2, 7, 1, "Short Vacation", "", LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), false, null);
        Event event3 = new Event(3, 1, 1, "Birthday", "", LocalDate.of(1987, 4, 1), LocalDate.of(1986, 1, 1), false, null);
        Event event4 = new Event(4, 8, 1, "Puperino", "", LocalDate.of(2008, 4, 16), LocalDate.of(2014, 04, 19), false, null);
        Event event5 = new Event(5, 9, 1, "Boo Cat", "", LocalDate.of(2005, 4, 25), null, true, null);
        Event event6 = new Event(6, 4, 1, "High School", "", LocalDate.of(2001, 04, 25), LocalDate.of(2005, 05, 19), false, null);
        Event event7 = new Event(7, 4, 1, "College", "", LocalDate.of(2006, 04, 25), LocalDate.of(2010, 05, 19), false, null);
        Event event8 = new Event(8, 5, 1, "Second Job", "", LocalDate.of(2012, 04, 25), LocalDate.of(2018, 05, 19), false, null);
        Event event9 = new Event(9, 5, 1, "First Job", "", LocalDate.of(2008, 04, 25), LocalDate.of(2010, 05, 19), false, null);
        Event event10 = new Event(10, 6, 1, "Client Meeting in Sacramento", "", LocalDate.of(2017, 03, 15), LocalDate.of(2017, 03, 20), false, null);
        Event event11 = new Event(11, 8, 1, "Pupperino 2", "", LocalDate.of(2010, 04, 19), LocalDate.of(2020, 04, 19), false, null);
        Event event12 = new Event(12, 9, 1, "Cat 2", "", LocalDate.of(2019, 05, 19), LocalDate.of(2019, 12, 19),false, null);
        Event event13 = new Event(13, 2, 1, "Get Passport", "", LocalDate.of(2007, 8, 25), null, false, null);

        return List.of(event1, event2, event3, event4, event5, event6,
                event7, event8, event9, event10, event11,
                event12, event13);
    }

    /**
     * Event group methods
     */

    public List<EventGroup> getEventGroups() {
        return (List<EventGroup>) data.get("eventGroups");
    }
    
    private List<EventGroup> createEventGroups() {
        EventGroup eg1 = new EventGroup(1, "Life Events", 1);
        EventGroup eg2 = new EventGroup(2, "Travel", 1);
        EventGroup eg3 = new EventGroup(3, "Pets", 1);
        EventGroup eg4 = new EventGroup(4, "Education", 1);
        EventGroup eg5 = new EventGroup(5, "Jobs", 1);
        EventGroup eg6 = new EventGroup(6, "Business Trips", 1);
        EventGroup eg7 = new EventGroup(7, "Vacation", 1);
        EventGroup eg8 = new EventGroup(8, "Dogs", 1);
        EventGroup eg9 = new EventGroup(9, "Cats", 1);
        
        return List.of(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9);
    }
}
