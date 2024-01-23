package com.mjc.school.repository.implementation.model;

import java.time.LocalDateTime;

public class NewsModel {
    private long newsId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private long authorId;

    NewsModel() {}

    public NewsModel(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public NewsModel(long newsId, String title, String content, LocalDateTime createdDate, LocalDateTime lastUpdatedDate, long authorId){
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.authorId = authorId;
    }

    public static class NewsBuilder {
        private final NewsModel newsModel;

        public NewsBuilder() {
            newsModel = new NewsModel();
        }


        public NewsBuilder setNewsId (long id) {
            newsModel.newsId = id;
            return this;
        }

        public NewsBuilder setNewsTitle(String title) {
            newsModel.title = title;
            return this;
        }

        public NewsBuilder setNewsContent (String content) {
            newsModel.content = content;
            return this;
        }

        public NewsBuilder setCreatedDate (LocalDateTime createdDate) {
            newsModel.createdDate = createdDate;
            return this;
        }

        public NewsBuilder setLastUpdateDate (LocalDateTime createdDate) {
            newsModel.lastUpdatedDate = createdDate;
            return this;
        }

        public NewsBuilder setAuthorId (long authorId) {
            newsModel.authorId = authorId;
            return this;
        }


        public long getNewsId () {
            return newsModel.newsId;
        }

        public String getNewsTitle() {
            return newsModel.title;
        }

        public String getNewsContent() {
            return newsModel.content;
        }

        public LocalDateTime getCreatedDate() {
            return newsModel.createdDate;
        }

        public LocalDateTime getLastUpdateDate() {
            return newsModel.lastUpdatedDate;
        }

        public NewsModel build() {
            return newsModel;
        }
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