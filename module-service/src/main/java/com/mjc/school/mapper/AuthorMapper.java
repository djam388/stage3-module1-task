package com.mjc.school.mapper;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.dto.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface AuthorMapper {
    AuthorDto getModelFromEntity(AuthorModel authorModel);
    AuthorModel getEntityFromModel(AuthorDto authorDto);
    List<AuthorDto> getModelListFromEntityList(List<AuthorModel> authorModelList);
}
