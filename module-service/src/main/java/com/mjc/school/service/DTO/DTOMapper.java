package com.mjc.school.service.DTO;

import com.mjc.school.repository.News;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DTOMapper {
    private final ModelMapper modelMapper;
    private final List<DTO> allDTO = new ArrayList<>();

    public DTOMapper() {
        this.modelMapper = new ModelMapper();
    }

    public DTO convertToDTO(News news){
        return modelMapper.map(news, DTO.class);
    }

    public List<DTO> convertToDTOList(List<News> newsList){
        for (News news : newsList) this.allDTO.add(convertToDTO(news));
        return this.allDTO;
    }

    public News convertToNews(DTO dto) {
        return new News(
                dto.getNewsId(),
                dto.getNewsTitle(),
                dto.getNewsContent(),
                dto.getCreatedDate(),
                dto.getLastUpdateDate(),
                dto.getAuthorId()
        );
    }
}
