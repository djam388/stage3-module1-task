package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.News;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    News getModelFromEntity(com.mjc.school.repository.model.News news);
    com.mjc.school.repository.model.News getEntityFromModel(News news);
    List<News> getModelListFromEntityList(List<com.mjc.school.repository.model.News> newsList);


}
