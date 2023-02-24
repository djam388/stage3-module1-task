package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.News;
import com.mjc.school.service.dto.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    NewsDto getModelFromEntity(News news);
    News getEntityFromModel(NewsDto newsDto);
    List<NewsDto> getModelListFromEntityList(List<News> newsList);


}
