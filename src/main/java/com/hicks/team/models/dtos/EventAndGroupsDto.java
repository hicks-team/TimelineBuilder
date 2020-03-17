package com.hicks.team.models.dtos;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;

import java.util.List;

public class EventAndGroupsDto {

    private List<Event> userEvents;
    private List<EventGroup> userEventGroups;

    public EventAndGroupsDto(List<Event> userEvents, List<EventGroup> eventGroups) {
        this.userEvents = userEvents;
        this.userEventGroups = eventGroups;
    }

    public List<Event> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<Event> userEvents) {
        this.userEvents = userEvents;
    }

    public List<EventGroup> getUserEventGroups() {
        return userEventGroups;
    }

    public void setUserEventGroups(List<EventGroup> userEventGroups) {
        this.userEventGroups = userEventGroups;
    }
}
