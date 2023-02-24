package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.News;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    News getModelFromEntity(NewsModel newsModel);
    NewsModel getEntityFromModel(News news);
    List<News> getModelListFromEntityList(List<NewsModel> newsModelList);


}
