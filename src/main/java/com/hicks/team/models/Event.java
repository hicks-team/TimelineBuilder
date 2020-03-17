package com.hicks.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class Event {

    private long id;
    private int group;
    private long userId;
    private String title = "";
    private String description = "";
    private LocalDate start;
    private LocalDate end;
    private Long parent;

    public Event(
            long id,
            int group,
            long userId,
            String title,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            Long parent) {
        this.id = id;
        this.group = group;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.start = startDate;
        this.end = endDate;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.format("Event [%d] %s", id, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty("content")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }
}
