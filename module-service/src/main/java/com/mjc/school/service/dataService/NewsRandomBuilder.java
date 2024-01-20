package com.mjc.school.service.dataService;

import com.mjc.school.repository.News;
import com.mjc.school.service.DTO.DTO;
import com.mjc.school.service.DTO.DTOMapper;
import com.mjc.school.service.exeptions.Exceptions;
import com.mjc.school.service.exeptions.InputChecker;
import com.mjc.school.service.exeptions.InputExceptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRandomBuilder {
    private static final int TOTAL_NUMBER_OF_NEWS = 20;
    private final InputChecker inputChecker = InputChecker.getInputChecker();

    private List<News> allNews = new ArrayList<>();
    private List<DTO> allDTO = new ArrayList<>();

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
            this.allDTO.add(new DTOMapper().convertToDTO(news));
        }
    }

    public List<DTO> getAllNews() {
        return this.allDTO;
    }

    public DTO getNewsById(long id) throws InputExceptions {
        if (id >= allDTO.size()) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        else return this.allDTO.get((int) id);
    }

    public void createNews(DTO dto) {
        this.allDTO.add(dto);
        dto.setNewsId(this.allDTO.size() + 1);
        dto.setCreatedDate(LocalDateTime.now());
        dto.setLastUpdateDate(LocalDateTime.now());
    }

    public void updateNewsById(long id, DTO dto) throws InputExceptions {
        if (id >= allDTO.size()) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        else {
            this.allDTO.set((int) id, dto);
            dto.setLastUpdateDate(LocalDateTime.now());
        }
    }

    public void removeNewsById(long id) throws InputExceptions {
        if (id >= allDTO.size()) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        else this.allDTO.remove((int) id);
    }

    public static NewsRandomBuilder getNewsRandomBuilder() throws IOException {
        return getNew.RANDOM_BUILDER;
    }

    public static class getNew {
        static final NewsRandomBuilder RANDOM_BUILDER;

        static {
            try {
                RANDOM_BUILDER = new NewsRandomBuilder();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private getNew() {}
    }
}
