package com.mjc.school.repository.implementation;

import com.mjc.school.repository.Author;
import com.mjc.school.repository.News;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRandomBuilder {
    private static final int TOTAL_NUMBER_OF_NEWS = 20;
    private static NewsRandomBuilder newsRandomBuilder;
    private final List<News> allNews = new ArrayList<>();

    private NewsRandomBuilder() throws IOException {
        RandomGetter randomGetter = new RandomGetter();
        randomGetter.createAuthorId();
        for (long i = 0; i <= TOTAL_NUMBER_OF_NEWS - 1; i++) {
            LocalDateTime createdDate = randomGetter.getRandomCreatedDate();
            LocalDateTime lastUpdatedDate = randomGetter.getRandomLastUpdatedDate(createdDate);
            News news = new News.NewsBuilder()
                    .setNewsId(i + 1)
                    .setNewsTitle(randomGetter.getRandomTitle())
                    .setNewsContent(randomGetter.getRandomContent())
                    .setCreatedDate(createdDate)
                    .setLastUpdateDate(lastUpdatedDate)
                    .setAuthorId(randomGetter.getRandomAuthorId())
                    .build();
            this.allNews.add(news);
        }
    }

    public List<News> getAllNews() {
        return this.allNews;
    }

    public List<Author> getAllAuthors() {
        return new RandomGetter().getAllAuthors();
    }

    public static NewsRandomBuilder getNewsRandomBuilder() throws IOException {
        if (newsRandomBuilder == null) return new NewsRandomBuilder();
        return newsRandomBuilder;
    }
}
