package com.mjc.school.repository;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final int TOTAL_NUMBER_OF_NEWS = 20;
    private static DataSource dataSource;
    private final List<NewsModel> allNews = new ArrayList<>();

    public DataSource() throws IOException {
        RandomGetter randomGetter = new RandomGetter();
        randomGetter.createAuthorId();
        for (long i = 0; i <= TOTAL_NUMBER_OF_NEWS - 1; i++) {
            LocalDateTime createdDate = randomGetter.getRandomCreatedDate();
            LocalDateTime lastUpdatedDate = randomGetter.getRandomLastUpdatedDate(createdDate);
            NewsModel newsModel = new NewsModel.NewsBuilder()
                    .setNewsId(i + 1)
                    .setNewsTitle(randomGetter.getRandomTitle())
                    .setNewsContent(randomGetter.getRandomContent())
                    .setCreatedDate(createdDate)
                    .setLastUpdateDate(lastUpdatedDate)
                    .setAuthorId(randomGetter.getRandomAuthorId())
                    .build();
            this.allNews.add(newsModel);
        }
    }

    public List<NewsModel> getAllNews() {
        return this.allNews;
    }

    public List<AuthorModel> getAllAuthors() {
        return new RandomGetter().getAllAuthors();
    }

    public static DataSource getDataSource() throws IOException {
        if (dataSource == null) return new DataSource();
        return dataSource;
    }
}
