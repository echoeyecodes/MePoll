package com.yata.echonotes.Models;

import java.sql.Timestamp;
import java.util.List;

public class NewsModel {
    private String title;
    private String description;
    private String timestamp;
    private String thumbnail_url;
    private List<String> options;
    private List<String> mutal_voters;

    public NewsModel(String title, String description, String timestamp, String thumbnail_url, List<String> options, List<String> mutal_voters) {
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
        this.mutal_voters = mutal_voters;
        this.options = options;
        this.thumbnail_url = thumbnail_url;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<String> getMutal_voters() {
        return mutal_voters;
    }

    public void setMutal_voters(List<String> mutal_voters) {
        this.mutal_voters = mutal_voters;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
