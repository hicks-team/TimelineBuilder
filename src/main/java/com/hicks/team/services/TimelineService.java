package com.hicks.team.services;

import com.hicks.team.models.InvalidRequestException;
import com.hicks.team.models.Timeline;
import com.hicks.team.repositories.Timeline.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class TimelineService {

    @Qualifier("mockTimelineRepository")
    private TimelineRepository m_timelineRepository;

    @Autowired
    public TimelineService(TimelineRepository timelineRepository) {
        this.m_timelineRepository = timelineRepository;
    }

    public Timeline getUserTimeline(Supplier<Long> userId) {
        try {
            return m_timelineRepository.findByUserId(userId.get());
        } catch (NumberFormatException e) {
            throw new InvalidRequestException("User.ID must be integer");
        }
    }
}