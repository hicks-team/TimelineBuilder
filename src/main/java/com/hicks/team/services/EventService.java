package com.hicks.team.services;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
import com.hicks.team.models.InvalidRequestException;
import com.hicks.team.models.dtos.EventAndGroupsDto;
import com.hicks.team.repositories.Event.EventRepository;
import com.hicks.team.repositories.EventGroup.EventGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class EventService {

    @Qualifier("mockEventRepository")
    private EventRepository m_eventRepository;
    @Qualifier("mockEventGroupRepository")
    private EventGroupRepository m_eventGroupRepository;

    @Autowired
    public EventService(EventRepository eventRepository, EventGroupRepository eventGroupRepository) {
        this.m_eventRepository = eventRepository;
        this.m_eventGroupRepository = eventGroupRepository;
    }

    public List<Event> getUserEvents(Supplier<Long> userIdSupplier) {
        try {
            return m_eventRepository.findAllByUserId(userIdSupplier.get());
        } catch (NumberFormatException e) {
            throw new InvalidRequestException("User.ID must be integer");
        }
    }

    public EventAndGroupsDto getUserEventsAndGroups(Supplier<Long> userIdSupplier) {
        try {
            List<Event> userEvents = m_eventRepository.findAllByUserId(userIdSupplier.get());
            List<EventGroup> groups = m_eventGroupRepository.findAllByUserId(userIdSupplier.get());
            return new EventAndGroupsDto(userEvents, groups);
        } catch (NumberFormatException e) {
            throw new InvalidRequestException("User.ID must be integer");
        }
    }

    public void createEvent(Event event) {
        m_eventRepository.save(event);
    }

}
