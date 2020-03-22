package com.hicks.team.controllers;

import com.hicks.team.models.Event;
import com.hicks.team.models.User;
import com.hicks.team.models.dtos.EventAndGroupsDto;
import com.hicks.team.models.dtos.NewEventRequestDto;
import com.hicks.team.services.EventService;
import com.hicks.team.services.UserService;
import com.hicks.team.utils.StyleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService m_eventService;
    private UserService m_userService;

    @Autowired
    public EventController(EventService eventService, UserService userService) {
        this.m_eventService = eventService;
        this.m_userService = userService;
    }

    @GetMapping("/userEvents/{userId}")
    public EventAndGroupsDto getUserEvents(@PathVariable() String userId) {

        EventAndGroupsDto eventAndGroupsDto = m_eventService.getUserEventsAndGroups(() -> Long.parseLong(userId));

        //todo refactor this out to a more appropriate place and optimize
        //This will also require that users cannot enter an event with a title like 1,2,3 etc
        List<Integer> birthdayYearEvents = eventAndGroupsDto.getUserEvents()
                .stream()
                .filter(x -> {
                    try {
                        Integer.parseInt(x.getTitle());
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .map(x -> Integer.parseInt(x.getTitle()))
                .collect(Collectors.toList());

        List<Event> birthdayEventsToAdd = new ArrayList<>();

        User user = m_userService.getUser(() -> Long.parseLong(userId));
        LocalDate dob = user.getDob();
        LocalDate today = LocalDate.now();
        int years = today.getYear() - dob.getYear();
        for (int i = 0; i < years; i++) {
            if (!birthdayYearEvents.contains(i)) {
                birthdayEventsToAdd.add(new Event(100+i, null, 1, "" + i, "", "background",
                        dob.plusYears(i), dob.plusYears((i+1)), false, null, StyleUtils.getRandomBackgroundColor()));
            }
        }

        eventAndGroupsDto.getUserEvents().addAll(birthdayEventsToAdd);
        return eventAndGroupsDto;
    }

    @PostMapping(value = "/userEvents", consumes = "application/json")
    public HttpStatus createEvent(@RequestBody NewEventRequestDto eventRequest) {
        m_eventService.createEvent(eventRequest.event());

        return HttpStatus.OK;
    }

}
