package com.mjc.school.service.dataService;

import com.mjc.school.service.DTO.DTO;
import com.mjc.school.service.exeptions.InputChecker;
import com.mjc.school.service.exeptions.InputExceptions;

import java.io.IOException;
import java.util.List;

public class NewsOperations {
    private final NewsRandomBuilder randomBuilder;

    public NewsOperations() {
        try {
            randomBuilder = NewsRandomBuilder.getNewsRandomBuilder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DTO> getAllNews() {
        return this.randomBuilder.getAllNews();
    }

    public DTO getNewsById(long id) throws InputExceptions {
        return this.randomBuilder.getNewsById((int) id);
    }

    public void createNews(DTO dto) throws InputExceptions {
        this.randomBuilder.createNews(dto);
    }

    public void updateNewsById(long id, DTO dto) throws InputExceptions {
        this.randomBuilder.updateNewsById((int) id, dto);
    }

    public void removeNewsById(long id) throws InputExceptions {
        this.randomBuilder.removeNewsById((int) id);
    }

    public String toString(DTO dto) {
        return "NewsDtoResponse[id=" + dto.getNewsId()
                + ", title=" + dto.getNewsTitle()
                + ", content=" + dto.getNewsContent()
                + ", createDate=" + dto.getCreatedDate()
                + ", lastUpdatedDate=" + dto.getLastUpdateDate()
                + ", authorId=" + dto.getAuthorId()
                + "]";
    }
}