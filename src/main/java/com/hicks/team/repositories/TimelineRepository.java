package com.hicks.team.repositories;

import com.hicks.team.models.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

    Timeline findByUserId(long userId);

}
