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
        return eventAndGroupsDto;
    }

    @PostMapping(value = "/userEvents", consumes = "application/json")
    public HttpStatus createEvent(@RequestBody NewEventRequestDto eventRequest) {
        m_eventService.createEvent(eventRequest.event());
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/{userId}/{eventId}")
    public HttpStatus deleteEvent(@PathVariable String userId, @PathVariable String eventId) {
        return m_eventService.deleteEvent(() -> Long.parseLong(eventId));
    }

}
