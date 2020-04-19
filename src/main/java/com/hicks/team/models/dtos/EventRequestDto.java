package com.hicks.team.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hicks.team.models.Event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventRequestDto
{
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Long id;
    private Long group;
    private String content = "";
    private String start = "";
    private String end = "";
    private boolean current;
    private String type = "";
    private Integer userId;

    public Event event() {
        Event event = new Event(
                this.id,
                this.group,
                this.userId,
                this.content,
                this.type,
                getStart(),
                getEnd(),
                this.current,
                ""
        );

        return event;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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
