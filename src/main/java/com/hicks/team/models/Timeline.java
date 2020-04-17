package com.hicks.team.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Timeline {

    @Id @GeneratedValue
    private long id;
    private long userId;
    private String title = "";
    private String subTitle = "";

    public Timeline()
    {
    }

    public Timeline(long userId, String title, String subTitle) {
        this.userId = userId;
        this.title = title;
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return String.format("Timeline %d - %s", id, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeline timeline = (Timeline) o;
        return id == timeline.id;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
