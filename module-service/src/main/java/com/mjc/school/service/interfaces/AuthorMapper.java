package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorDto getModelFromEntity(AuthorModel authorModel);
    AuthorModel getEntityFromModel(AuthorDto authorDto);
    List<AuthorDto> getModelListFromEntityList(List<AuthorModel> authorModelList);
}
