package com.yata.echonotes.Models;

import java.sql.Timestamp;

public class NoteModel {
    private String title;
    private String content;
    private Timestamp timestamp;
    private String id;

    public NoteModel(String title, String content, Timestamp timestamp, String id) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
