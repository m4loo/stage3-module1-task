package com.mjc.school.repository.implementation;

import com.mjc.school.repository.DataSource;
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

    public NewsModel readById(Long id) {
        return dataSource.getAllNews().get(id.intValue());
    }

    public NewsModel createNews(NewsModel model) {
        model.setNewsId(dataSource.getAllNews().size() + 1);
        model.setCreatedDate(LocalDateTime.now());
        model.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().add(model);
        return model;
    }

    public NewsModel updateNewsById(NewsModel newsModel) {
        newsModel.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().set((int) newsModel.getNewsId(), newsModel);
        return newsModel;
    }
    public Boolean deleteById(long id) {
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
