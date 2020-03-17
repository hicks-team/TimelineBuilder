package com.hicks.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventGroup {

    private long id;
    private String title = "";
    private long userId;

    public EventGroup(long id, String title, long userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
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
}
