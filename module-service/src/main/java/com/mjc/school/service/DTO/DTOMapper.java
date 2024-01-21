package com.mjc.school.service.DTO;

import com.mjc.school.repository.NewsModel;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DTOMapper {
    private final ModelMapper modelMapper;
    private final List<DTO> allDTO = new ArrayList<>();

    public DTOMapper() {
        this.modelMapper = new ModelMapper();
    }

    public DTO convertToDTO(NewsModel newsModel){
        return modelMapper.map(newsModel, DTO.class);
    }

    public List<DTO> convertToDTOList(List<NewsModel> newsModelList){
        for (NewsModel newsModel : newsModelList) this.allDTO.add(convertToDTO(newsModel));
        return this.allDTO;
    }

    public NewsModel convertToNews(DTO dto) {
        return new NewsModel(
                dto.getNewsId(),
                dto.getNewsTitle(),
                dto.getNewsContent(),
                dto.getCreatedDate(),
                dto.getLastUpdateDate(),
                dto.getAuthorId()
        );
    }
}
