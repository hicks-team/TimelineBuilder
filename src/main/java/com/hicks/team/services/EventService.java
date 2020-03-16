package com.hicks.team.services;

import com.hicks.team.models.Event;
import com.hicks.team.models.InvalidRequestException;
import com.hicks.team.repositories.Event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class EventService {

    @Qualifier("mockEventRepository")
    private EventRepository m_eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.m_eventRepository = eventRepository;
    }

    public List<Event> getUserEvents(Supplier<Long> userIdSupplier) {
        try {
            return m_eventRepository.getEventsByUser(userIdSupplier.get());
        } catch (NumberFormatException e) {
            throw new InvalidRequestException("User.ID must be integer");
        }
    }

}
