package com.mjc.school.repository;

import java.time.LocalDateTime;

public class News {
    private long newsId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private long authorId;

    News () {}

    public News(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public News(long newsId, String title, String content, LocalDateTime createdDate, LocalDateTime lastUpdatedDate, long authorId){
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.authorId = authorId;
    }

    public static class NewsBuilder {
        private final News news;

        public NewsBuilder() {
            news = new News();
        }


        public NewsBuilder setNewsId (long id) {
            news.newsId = id;
            return this;
        }

        public NewsBuilder setNewsTitle(String title) {
            news.title = title;
            return this;
        }

        public NewsBuilder setNewsContent (String content) {
            news.content = content;
            return this;
        }

        public NewsBuilder setCreatedDate (LocalDateTime createdDate) {
            news.createdDate = createdDate;
            return this;
        }

        public NewsBuilder setLastUpdateDate (LocalDateTime createdDate) {
            news.lastUpdatedDate = createdDate;
            return this;
        }

        public NewsBuilder setAuthorId (long authorId) {
            news.authorId = authorId;
            return this;
        }


        public long getNewsId () {
            return news.newsId;
        }

        public String getNewsTitle() {
            return news.title;
        }

        public String getNewsContent() {
            return news.content;
        }

        public LocalDateTime getCreatedDate() {
            return news.createdDate;
        }

        public LocalDateTime getLastUpdateDate() {
            return news.lastUpdatedDate;
        }

        public News build() {
            return news;
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