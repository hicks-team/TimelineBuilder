package com.hicks.team;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
import com.hicks.team.models.Timeline;
import com.hicks.team.models.User;
import com.hicks.team.repositories.EventGroupRepository;
import com.hicks.team.repositories.EventRepository;
import com.hicks.team.repositories.TimelineRepository;
import com.hicks.team.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Setup {

    private UserRepository userRepository;
    private EventRepository eventRepository;
    private EventGroupRepository eventGroupRepository;
    private TimelineRepository timelineRepository;

    public Setup(UserRepository userRepository, EventRepository eventRepository,
                 EventGroupRepository eventGroupRepository, TimelineRepository timelineRepository)
    {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.eventGroupRepository = eventGroupRepository;
        this.timelineRepository = timelineRepository;
    }

    @Bean
    public CommandLineRunner runSetup() {
        return args -> {

            createUsers();
            createEventGroups();
            createEvents();
            createTimelines();
        };
    }

    private void createUsers() {
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

        userRepository.save(steve);
        userRepository.save(eric);
    }

    private void createEvents() {
        List<Event> events = List.of(
                new Event(eventGroupRepository.findByTitle("Life Events").getId(), 1, "Born", "point", LocalDate.of(1989, 4, 25), null, false, null),
                new Event(eventGroupRepository.findByTitle("Travel").getId(), 1, "Apply for Passport", "point", LocalDate.of(2007, 8, 25), null, false, null),
                new Event(eventGroupRepository.findByTitle("Travel").getId(), 1, "Get Passport", "point", LocalDate.of(2007, 9, 25), null, false, null),
                new Event(eventGroupRepository.findByTitle("Education").getId(), 1, "High School", "range", LocalDate.of(2001, 4, 25), LocalDate.of(2005, 5, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Education").getId(), 1, "College", "range", LocalDate.of(2006, 4, 25), LocalDate.of(2010, 5, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Jobs").getId(), 1, "Second Job", "range", LocalDate.of(2012, 4, 25), LocalDate.of(2018, 5, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Jobs").getId(), 1, "First Job", "range", LocalDate.of(2008, 4, 25), LocalDate.of(2010, 5, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Business Trips").getId(), 1, "Client Meeting in Sacramento", "range", LocalDate.of(2017, 3, 15), LocalDate.of(2017, 3, 20), false, null),
                new Event(eventGroupRepository.findByTitle("Vacation").getId(), 1, "Summer Vacation", "range", LocalDate.of(2014, 8, 15), LocalDate.of(2014, 8, 31), false, null),
                new Event(eventGroupRepository.findByTitle("Vacation").getId(), 1, "Short Vacation", "range", LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), false, null),
                new Event(eventGroupRepository.findByTitle("Dogs").getId(), 1, "Puperino", "range", LocalDate.of(2008, 4, 16), LocalDate.of(2014, 4, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Dogs").getId(), 1, "Pupperino 2", "range", LocalDate.of(2010, 4, 19), LocalDate.of(2020, 4, 19), false, null),
                new Event(eventGroupRepository.findByTitle("Cats").getId(), 1, "Boo Cat", "range", LocalDate.of(2005, 4, 25), null, true, null),
                new Event(eventGroupRepository.findByTitle("Cats").getId(), 1, "Cat 2", "range", LocalDate.of(2019, 5, 19), LocalDate.of(2019, 12, 19), false, null));

        eventRepository.saveAll(events);

        userRepository.findAll().forEach(user -> {
            if (!user.getDisplayName().equals("shicks"))
                return;
            
            List<Event> birthdayEvents = new ArrayList<>();

            LocalDate dob = user.getDob();
            LocalDate today = LocalDate.now();
            int years = today.getYear() - dob.getYear();

            String even = "background-color: rgba(255,255,255,0.1)";
            String odd = "background-color: rgba(200,200,200,0.1)";

            for (int i = 0; i < years; i++) {
                birthdayEvents.add(new Event(null, 1, "" + i, "background",
                        dob.plusYears(i), dob.plusYears((i+1)), false, i % 2 == 0 ? even : odd));
            }

            eventRepository.saveAll(birthdayEvents);
        });
    }

    private void createEventGroups() {
        List<EventGroup> eventGroups = List.of(
                new EventGroup("Life Events", 1),
                new EventGroup("Travel", 1),
                new EventGroup("Pets", 1),
                new EventGroup("Education", 1),
                new EventGroup("Jobs", 1)
        );

        eventGroupRepository.saveAll(eventGroups);

        List<EventGroup> groupsWithParents = List.of(
                new EventGroup("Business Trips", 1, eventGroupRepository.findByTitle("Travel").getId()),
                new EventGroup("Vacation", 1, eventGroupRepository.findByTitle("Travel").getId()),
                new EventGroup("Dogs", 1, eventGroupRepository.findByTitle("Pets").getId()),
                new EventGroup("Cats", 1, eventGroupRepository.findByTitle("Pets").getId())
        );

        eventGroupRepository.saveAll(groupsWithParents);
    }

    private void createTimelines() {
        timelineRepository.save(new Timeline(1, "Steven's timeline", "A life through time"));
    }
}
