package com.mjc.school.repository.implementation;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.Interface;
import com.mjc.school.repository.NewsModel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NewsDataSourceRepository implements Interface<NewsModel> {
    private final DataSource dataSource;
    {
        try {
            dataSource = DataSource.getDataSource();
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

    public NewsModel create(NewsModel newsModel) {
        newsModel.setNewsId(dataSource.getAllNews().size() + 1);
        newsModel.setCreatedDate(LocalDateTime.now());
        newsModel.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().add(newsModel);
        return newsModel;
    }

    public NewsModel updateNewsById(NewsModel newsModel) {
        newsModel.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().set((int) newsModel.getNewsId(), newsModel);
        return newsModel;
    }
    public Boolean deleteById(Long id) {
        dataSource.getAllNews().remove(dataSource.getAllNews().get(id.intValue()));
        return true;
    }

    public boolean newsIsExist(long id) {
        return id > dataSource.getAllNews().size();
    }

    public boolean authorIsExist(long id) {
        return id > dataSource.getAllAuthors().size();
    }
}
