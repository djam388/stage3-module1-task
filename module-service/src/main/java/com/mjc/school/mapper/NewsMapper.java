package com.mjc.school.mapper;

import com.mjc.school.model.NewsModel;
import com.mjc.school.dto.NewsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsDto getModelFromEntity(NewsModel newsModel);
    NewsModel getEntityFromModel(NewsDto news);
    List<NewsDto> getModelListFromEntityList(List<NewsModel> newsModelList);


}
