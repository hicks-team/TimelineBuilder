package com.hicks.team.repositories;

import com.hicks.team.models.EventGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventGroupRepository extends JpaRepository<EventGroup, Long> {

    List<EventGroup> findAllByUserId(long userid);
    EventGroup findByTitle(String title);
}
