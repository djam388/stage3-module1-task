package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    NewsDto getModelFromEntity(NewsModel newsModel);
    NewsModel getEntityFromModel(NewsDto news);
    List<NewsDto> getModelListFromEntityList(List<NewsModel> newsModelList);


}
