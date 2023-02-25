package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.dto.NewsDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorDto getModelFromEntity(AuthorModel authorModel);
    AuthorModel getEntityFromModel(AuthorDto authorDto);
    List<AuthorDto> getModelListFromEntityList(List<AuthorModel> authorModelList);
}
