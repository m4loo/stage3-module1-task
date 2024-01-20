package com.mjc.school.service.DTO;

import com.mjc.school.repository.News;
import org.modelmapper.ModelMapper;

public class DTOMapper {
    private final ModelMapper modelMapper;

    public DTOMapper() {
        this.modelMapper = new ModelMapper();
    }

    public DTO convertToDTO(News news){
        return modelMapper.map(news, DTO.class);
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
