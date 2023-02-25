package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.interfaces.AuthorMapper;
import com.mjc.school.service.interfaces.AuthorServiceInterface;
import com.mjc.school.service.interfaces.NewsMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class AuthorService implements AuthorServiceInterface {
    private AuthorRepository authorRepository = new AuthorRepository();
    private AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
    @Override
    public List<AuthorDto> readAll() {
        return this.authorMapper.getModelListFromEntityList(authorRepository.readAll());
    }

    @Override
    public AuthorDto readBy(long id) {
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
    public boolean delete(long id) {
        if (readAll().size() >= (int) id) {
            authorRepository.delete(id - 1);
            return true;
        }
        else {
            return false;
        }
    }
}