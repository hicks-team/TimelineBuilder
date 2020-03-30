package com.hicks.team.repositories;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
import com.hicks.team.models.Timeline;
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
        data.put("timelines", createTimelines());
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
        return List.of(
                new Event(1, 7, 1, "Summer Vacation", "", "range", LocalDate.of(2014, 8, 15), LocalDate.of(2014, 8, 31), false, null, null),
                new Event(2, 7, 1, "Short Vacation", "", "range", LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), false, null, null),
                new Event(3, 1, 1, "Born", "", "point", LocalDate.of(1989, 4, 25), null, false, null, null),
                new Event(4, 8, 1, "Puperino", "", "range", LocalDate.of(2008, 4, 16), LocalDate.of(2014, 4, 19), false, null, null),
                new Event(5, 9, 1, "Boo Cat", "", "range", LocalDate.of(2005, 4, 25), null, true, null, null),
                new Event(6, 4, 1, "High School", "", "range", LocalDate.of(2001, 4, 25), LocalDate.of(2005, 5, 19), false, null, null),
                new Event(7, 4, 1, "College", "", "range", LocalDate.of(2006, 4, 25), LocalDate.of(2010, 5, 19), false, null, null),
                new Event(8, 5, 1, "Second Job", "", "range", LocalDate.of(2012, 4, 25), LocalDate.of(2018, 5, 19), false, null, null),
                new Event(9, 5, 1, "First Job", "", "range", LocalDate.of(2008, 4, 25), LocalDate.of(2010, 5, 19), false, null, null),
                new Event(10, 6, 1, "Client Meeting in Sacramento", "", "range", LocalDate.of(2017, 3, 15), LocalDate.of(2017, 3, 20), false, null, null),
                new Event(11, 8, 1, "Pupperino 2", "", "range", LocalDate.of(2010, 4, 19), LocalDate.of(2020, 4, 19), false, null, null),
                new Event(12, 9, 1, "Cat 2", "", "range", LocalDate.of(2019, 5, 19), LocalDate.of(2019, 12, 19), false, null, null),
                new Event(13, 2, 1, "Apply for Passport", "", "point", LocalDate.of(2007, 8, 25), null, false, null, null),
                new Event(14, 2, 1, "Get Passport", "", "point", LocalDate.of(2007, 9, 25), null, false, null, null));
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
        eg2.getNestedGroupIds().add(6);
        eg2.getNestedGroupIds().add(7);

        EventGroup eg3 = new EventGroup(3, "Pets", 1);
        eg3.getNestedGroupIds().add(8);
        eg3.getNestedGroupIds().add(9);

        EventGroup eg4 = new EventGroup(4, "Education", 1);
        EventGroup eg5 = new EventGroup(5, "Jobs", 1);
        EventGroup eg6 = new EventGroup(6, "Business Trips", 1);
        EventGroup eg7 = new EventGroup(7, "Vacation", 1);
        EventGroup eg8 = new EventGroup(8, "Dogs", 1);
        EventGroup eg9 = new EventGroup(9, "Cats", 1);
        
        return List.of(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9);
    }

    /**
     * Timeline stuff
     */

    public Timeline findByUserId(long userId) {
        return (Timeline) data.get("timelines").get(0);
    }

    private List<Timeline> createTimelines() {
        return List.of(
                new Timeline(1, "Steven's timeline", "A life through time")
        );
    }
}
