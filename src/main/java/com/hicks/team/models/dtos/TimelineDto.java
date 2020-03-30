package com.hicks.team.models.dtos;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
import com.hicks.team.models.Timeline;

import java.util.List;

public class TimelineDto {

    private Timeline m_timeline;
    private List<Event> m_eventList;
    private List<EventGroup> m_eventGroupList;


    public Timeline getTimeline() {
        return m_timeline;
    }

    public void setTimeline(Timeline timeline) {
        m_timeline = timeline;
    }

    public List<Event> getEventList() {
        return m_eventList;
    }

    public void setEventList(List<Event> eventList) {
        m_eventList = eventList;
    }

    public List<EventGroup> getEventGroupList() {
        return m_eventGroupList;
    }

    public void setEventGroupList(List<EventGroup> eventGroupList) {
        m_eventGroupList = eventGroupList;
    }
}
