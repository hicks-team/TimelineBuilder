package com.hicks.team.services;

import com.hicks.team.models.Event;
import com.hicks.team.models.EventGroup;
import com.hicks.team.models.InvalidRequestException;
import com.hicks.team.models.User;
import com.hicks.team.models.dtos.EventAndGroupsDto;
import com.hicks.team.repositories.EventGroupRepository;
import com.hicks.team.repositories.EventRepository;
import com.hicks.team.repositories.UserRepository;
import com.hicks.team.utils.StyleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventRepository m_eventRepository;
    private EventGroupRepository m_eventGroupRepository;
    private UserRepository m_userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, EventGroupRepository eventGroupRepository, UserRepository userRepository) {
        this.m_eventRepository = eventRepository;
        this.m_eventGroupRepository = eventGroupRepository;
        this.m_userRepository = userRepository;
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

    public void updateEvent(Event event) {
        m_eventRepository.save(event);
    }

    public HttpStatus deleteEvent(Supplier<Long> eventIdSupplier) {
        try {
            m_eventRepository.deleteById(eventIdSupplier.get());
            return HttpStatus.OK;
        }catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
