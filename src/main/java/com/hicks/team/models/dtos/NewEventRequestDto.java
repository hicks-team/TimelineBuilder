package com.hicks.team.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hicks.team.models.Event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewEventRequestDto {

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Integer group;
    private String title = "";
    private String description = "";
    private String start = "";
    private String end = "";
    private boolean current;
    private String type = "";
    private Integer userId;

    public Event event() {
        Event event = new Event(
                1000,
                this.group,
                this.userId,
                this.title,
                this.description,
                this.type,
                getStart(),
                getEnd(),
                this.current,
                null,
                ""
        );

        return event;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @JsonProperty("content")
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart() {
        return LocalDate.parse(this.start, dtf);
    }

    public void setStart(String start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return LocalDate.parse(this.end, dtf);
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isCurrent() {
        return current;
    }

    @JsonProperty("on")
    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
