package com.mjc.school.repository.implementation;

import com.mjc.school.repository.NewsModel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NewsMethods {
    private final DataSource dataSource;
    {
        try {
            dataSource = DataSource.getNewsRandomBuilder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    public NewsModel readById(long id) {
        return dataSource.getAllNews().get((int) id);
    }

    public NewsModel createNews(NewsModel newsModel) {
        newsModel.setNewsId(dataSource.getAllNews().size() + 1);
        newsModel.setCreatedDate(LocalDateTime.now());
        newsModel.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().add(newsModel);
        return newsModel;
    }

    public NewsModel updateNewsById(long id, NewsModel newsModel) {
        newsModel.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().set((int) id, newsModel);
        return newsModel;
    }
    public boolean deleteById(long id) {
        dataSource.getAllNews().remove(dataSource.getAllNews().get((int) id));
        return true;
    }

    public boolean newsIsExist(long id) {
        return id > dataSource.getAllNews().size();
    }

    public boolean authorIsExist(long id) {
        return id > dataSource.getAllAuthors().size();
    }
}
