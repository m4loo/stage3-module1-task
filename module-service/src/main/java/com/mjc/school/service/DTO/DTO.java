package com.mjc.school.service.DTO;

import java.time.LocalDateTime;

public class DTO {
    private long newsId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private long authorId;

    public DTO () {}

    public DTO(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public DTO(long newsId, String title, String content, LocalDateTime createdDate, LocalDateTime lastUpdatedDate, long authorId){
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.authorId = authorId;
    }

    public void setNewsId (long id) {
        this.newsId = id;
    }

    public void setNewsTitle(String title) {
        this.title = title;
    }

    public void setNewsContent (String content) {
        this.content = content;
    }

    public void setCreatedDate (LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdateDate (LocalDateTime createdDate) {
        this.lastUpdatedDate = createdDate;
    }

    public void setAuthorId (long authorId) {
        this.authorId = authorId;
    }


    public long getNewsId () {
        return this.newsId;
    }

    public String getNewsTitle() {
        return this.title;
    }

    public String getNewsContent() {
        return this.content;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return this.lastUpdatedDate;
    }

    public long getAuthorId() {
        return this.authorId;
    }
}