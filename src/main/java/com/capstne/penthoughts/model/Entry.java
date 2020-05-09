package com.capstne.penthoughts.model;

import java.time.LocalDateTime;

public class Entry {
    private long id;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String title;
    private String message;

    public Entry(long id, LocalDateTime createdTime, LocalDateTime updatedTime, String title, String message) {
        this.id = id;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.title = title;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
