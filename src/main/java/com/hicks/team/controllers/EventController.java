package com.hicks.team.controllers;

import com.hicks.team.models.Event;
import com.hicks.team.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService m_eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.m_eventService = eventService;
    }

    @RequestMapping("/{userId}")
    public List<Event> getUserEvents(@PathVariable() String userId) {
        return m_eventService.getUserEvents(() -> Long.parseLong(userId));
    }

}
