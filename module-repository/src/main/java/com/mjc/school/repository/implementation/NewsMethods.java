package com.mjc.school.repository.implementation;

import com.mjc.school.repository.News;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NewsMethods {
    private final NewsRandomBuilder newsRandomBuilder;
    {
        try {
            newsRandomBuilder = NewsRandomBuilder.getNewsRandomBuilder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> getAllNews() {
        return newsRandomBuilder.getAllNews();
    }

    public News getNewsById(long id) {
        return newsRandomBuilder.getAllNews().get((int) id);
    }

    public News createNews(News news) {
        news.setNewsId(newsRandomBuilder.getAllNews().size() + 1);
        news.setCreatedDate(LocalDateTime.now());
        news.setLastUpdateDate(LocalDateTime.now());
        newsRandomBuilder.getAllNews().add(news);
        return news;
    }

    public News updateNewsById(long id, News news) {
        news.setLastUpdateDate(LocalDateTime.now());
        newsRandomBuilder.getAllNews().set((int) id, news);
        return news;
    }
    public boolean removeNewsById(long id) {
        newsRandomBuilder.getAllNews().remove(newsRandomBuilder.getAllNews().get((int) id));
        return true;
    }

    public boolean newsIsExist(long id) {
        return id > newsRandomBuilder.getAllNews().size();
    }

    public boolean authorIsExist(long id) {
        return id > newsRandomBuilder.getAllAuthors().size();
    }
}
