package com.mjc.school.repository.implementation;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.NewsModel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NewsDataSourceRepository {
    private final DataSource newsDataSource;

    public NewsDataSourceRepository() {
        try {
            newsDataSource = new DataSource();
        } catch (IOException e) {
            throw new DataSourceInitializationException("Error initializing data source.", e);
        }
    }

    public List<NewsModel> readAll() {
        return newsDataSource.getAllNews();
    }

    public NewsModel readById(Long id) {
        return newsDataSource.getAllNews().get(id.intValue());
    }

    public NewsModel createNews(NewsModel newsModel) {
        newsModel.setNewsId((long) newsDataSource.getAllNews().size() + 1);
        newsModel.setCreatedDate(LocalDateTime.now());
        newsModel.setLastUpdateDate(LocalDateTime.now());
        newsDataSource.getAllNews().add(newsModel);
        return newsModel;
    }

    public NewsModel updateNewsById(NewsModel newsModel) {
        newsModel.setLastUpdateDate(LocalDateTime.now());
        newsDataSource.getAllNews().set((int) newsModel.getNewsId(), newsModel);
        return newsModel;
    }
    public Boolean deleteById(Long id) {
        newsDataSource.getAllNews().remove(newsDataSource.getAllNews().get(id.intValue()));
        return true;
    }

    public boolean newsIsExist(long id) {
        return id > newsDataSource.getAllNews().size();
    }

    public boolean authorIsExist(long id) {
        return id > newsDataSource.getAllAuthors().size();
    }

    private static class DataSourceInitializationException extends RuntimeException {
        public DataSourceInitializationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
