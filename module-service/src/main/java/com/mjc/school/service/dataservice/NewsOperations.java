package com.mjc.school.service.dataservice;

import com.mjc.school.repository.implementation.NewsDataSourceRepository;
import com.mjc.school.service.dto.DTO;
import com.mjc.school.service.dto.DTOMapper;
import com.mjc.school.service.exeptions.Exceptions;
import com.mjc.school.service.exeptions.InputExceptions;

import java.util.List;

public class NewsOperations {
    private final NewsDataSourceRepository newsDataSourceRepository = new NewsDataSourceRepository();
    private final DTOMapper dtoMapper = new DTOMapper();

    public List<DTO> getAllNews() {
        return dtoMapper.convertToDTOList(newsDataSourceRepository.readAll());
    }

    public DTO getNewsById(long id) throws InputExceptions {
        if (newsDataSourceRepository.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getErrorInfo(id));
        return dtoMapper.convertToDTO(newsDataSourceRepository.readById(id));
    }

    public DTO createNews(DTO dto) throws InputExceptions {
        if (newsDataSourceRepository.authorIsExist(dto.getAuthorId())) throw new InputExceptions(Exceptions.ERROR_AUTHOR_ID_NOT_EXIST.getErrorInfo(dto.getAuthorId()));
        return dtoMapper.convertToDTO(newsDataSourceRepository.create(dtoMapper.convertToNews(dto)));
    }

    public DTO updateNewsById(long id, DTO dto) throws InputExceptions {
        if (newsDataSourceRepository.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getErrorInfo(id));
        if (newsDataSourceRepository.authorIsExist(dto.getAuthorId())) throw new InputExceptions(Exceptions.ERROR_AUTHOR_ID_NOT_EXIST.getErrorInfo(dto.getAuthorId()));
        return dtoMapper.convertToDTO(newsDataSourceRepository.updateNewsById(dtoMapper.convertToNews(dto)));
    }

    public boolean removeNewsById(long id) throws InputExceptions {
        if (newsDataSourceRepository.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getErrorInfo(id));
        return newsDataSourceRepository.deleteById(id);
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

    public String toString(List<DTO> dtoList) {
        StringBuilder result = new StringBuilder();
        for (DTO dto : dtoList) result.append(toString(dto)).append("\n");
        return result.toString();
    }
}