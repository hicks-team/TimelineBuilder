package com.hicks.team.controllers;

import com.hicks.team.models.Timeline;
import com.hicks.team.models.dtos.EventAndGroupsDto;
import com.hicks.team.models.dtos.TimelineDto;
import com.hicks.team.services.EventService;
import com.hicks.team.services.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    private TimelineService m_timelineService;
    private EventService    m_eventService;

    public TimelineController(TimelineService timelineService, EventService eventService) {
        this.m_timelineService = timelineService;
        this.m_eventService = eventService;
    }

    @GetMapping("/{userId}")
    public TimelineDto getUserTimeline(@PathVariable String userId) {
        Supplier<Long> userIdSupplier = () -> Long.parseLong(userId);
        Timeline timeline = m_timelineService.getUserTimeline(userIdSupplier);
        EventAndGroupsDto eventAndGroupsDto = m_eventService.getUserEventsAndGroups(userIdSupplier);

        TimelineDto timelineDto = new TimelineDto();
        timelineDto.setTimeline(timeline);
        timelineDto.setEventList(eventAndGroupsDto.getUserEvents());
        timelineDto.setEventGroupList(eventAndGroupsDto.getUserEventGroups());
        return timelineDto;
    }

}
