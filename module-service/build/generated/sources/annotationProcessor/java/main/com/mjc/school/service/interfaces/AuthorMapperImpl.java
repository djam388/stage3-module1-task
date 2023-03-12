package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T00:23:08+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto getModelFromEntity(AuthorModel authorModel) {
        if ( authorModel == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( authorModel.getId() );
        authorDto.setName( authorModel.getName() );

        return authorDto;
    }

    @Override
    public AuthorModel getEntityFromModel(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        long id = 0L;
        String name = null;

        id = authorDto.getId();
        name = authorDto.getName();

        AuthorModel authorModel = new AuthorModel( id, name );

        return authorModel;
    }

    @Override
    public List<AuthorDto> getModelListFromEntityList(List<AuthorModel> authorModelList) {
        if ( authorModelList == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authorModelList.size() );
        for ( AuthorModel authorModel : authorModelList ) {
            list.add( getModelFromEntity( authorModel ) );
        }

        return list;
    }
}
