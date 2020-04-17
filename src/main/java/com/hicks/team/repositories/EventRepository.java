package com.hicks.team.repositories;

import com.hicks.team.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByUserId(long userId);

}
