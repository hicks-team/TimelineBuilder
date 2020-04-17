package com.hicks.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventGroup {

    @Id @GeneratedValue
    private long id;
    private String title = "";
    private long userId;
    private Long parentGroupId;

    public EventGroup()
    {
    }

    public EventGroup(String title, long userId) {
        this.title = title;
        this.userId = userId;
    }

    public EventGroup(String title, long userId, long parentGroupId) {
        this.title = title;
        this.userId = userId;
        this.parentGroupId = parentGroupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("content")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getParentGroupId()
    {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId)
    {
        this.parentGroupId = parentGroupId;
    }
}
