package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.interfaces.AuthorMapper;
import com.mjc.school.service.interfaces.AuthorServiceInterface;
import com.mjc.school.service.validator.Validator;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class AuthorService implements AuthorServiceInterface {
    private final AuthorRepository authorRepository = new AuthorRepository();
    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

    private Validator validator = new Validator();


    private static AuthorService INSTANCE;

    private AuthorService() {

    }

    public static AuthorService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthorService();
        }
        return INSTANCE;
    }


    @Override
    public List<AuthorDto> readAll() {
        return this.authorMapper.getModelListFromEntityList(authorRepository.readAll());
    }

    @Override
    public AuthorDto readBy(Long id) {
        return this.authorMapper.getModelFromEntity(authorRepository.readBy(id));
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        return this.authorMapper.getModelFromEntity(authorRepository.create(this.authorMapper.getEntityFromModel(authorDto)));
    }

    @Override
    public AuthorDto update(AuthorDto authorDto) {
        authorDto.setId(authorRepository.update(this.authorMapper.getEntityFromModel(authorDto)).getId());
        return authorDto;
    }

    @Override
    public Boolean delete(Long id) {
        if (validator.validateAuthorId(id)) {
            authorRepository.delete(id - 1);
            return true;
        }
        else {
            return false;
        }
    }
}