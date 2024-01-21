package com.mjc.school.service.dataService;

import com.mjc.school.repository.implementation.NewsMethods;
import com.mjc.school.service.DTO.DTO;
import com.mjc.school.service.DTO.DTOMapper;
import com.mjc.school.service.exeptions.Exceptions;
import com.mjc.school.service.exeptions.InputExceptions;

import java.util.List;

public class NewsOperations {
    private final NewsMethods newsMethods = new NewsMethods();
    private final DTOMapper DTOMapper = new DTOMapper();

    public List<DTO> getAllNews() {
        return DTOMapper.convertToDTOList(newsMethods.readAll());
    }

    public DTO getNewsById(long id) throws InputExceptions {
        if (newsMethods.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        return DTOMapper.convertToDTO(newsMethods.readById(id));
    }

    public DTO createNews(DTO dto) throws InputExceptions {
        if (newsMethods.authorIsExist(dto.getAuthorId())) throw new InputExceptions(Exceptions.ERROR_AUTHOR_ID_NOT_EXIST.getERROR_INFO(dto.getAuthorId()));
        return DTOMapper.convertToDTO(newsMethods.createNews(DTOMapper.convertToNews(dto)));
    }

    public DTO updateNewsById(long id, DTO dto) throws InputExceptions {
        if (newsMethods.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        if (newsMethods.authorIsExist(dto.getAuthorId())) throw new InputExceptions(Exceptions.ERROR_AUTHOR_ID_NOT_EXIST.getERROR_INFO(dto.getAuthorId()));
        return DTOMapper.convertToDTO(newsMethods.updateNewsById(id, DTOMapper.convertToNews(dto)));
    }

    public boolean removeNewsById(long id) throws InputExceptions {
        if (newsMethods.newsIsExist(id)) throw new InputExceptions(Exceptions.ERROR_NEWS_NOT_EXIST.getERROR_INFO(id));
        return newsMethods.deleteById(id);
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

    public String toString(List<DTO> DTOlist) {
        String result = "";
        for (DTO dto : DTOlist) result += toString(dto) + "\n";
        return result;
    }
}