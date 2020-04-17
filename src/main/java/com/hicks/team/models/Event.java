package com.hicks.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Event {

    @Id @GeneratedValue
    private long id;
    private Long groupId;
    private long userId;
    private String title = "";
    private String description = "";
    private String type = "";
    private LocalDate start;
    private LocalDate end;
    private boolean current;
    private String style;

    public Event()
    {
    }

    public Event(
            Long groupId,
            long userId,
            String title,
            String description,
            String type,
            LocalDate startDate,
            LocalDate endDate,
            boolean current,
            String style) {
        this.groupId = groupId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.start = startDate;
        this.end = endDate;
        this.current = current;
        this.style = style;
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

    @JsonProperty("group")
    public Long getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Long groupId)
    {
        this.groupId = groupId;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
