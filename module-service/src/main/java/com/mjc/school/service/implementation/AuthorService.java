package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.interfaces.AuthorMapper;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class AuthorService implements com.mjc.school.service.interfaces.AuthorService {
    private final AuthorRepository authorRepository = new AuthorRepository();
    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

    public AuthorService() {

    }

    @Override
    public List<AuthorDto> readAll() {
        return authorMapper.getModelListFromEntityList(authorRepository.readAll());
    }

    @Override
    public AuthorDto readBy(Long id) {
        return authorMapper.getModelFromEntity(authorRepository.readBy(id));
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        return authorMapper.getModelFromEntity(authorRepository.create(authorMapper.getEntityFromModel(authorDto)));
    }

    @Override
    public AuthorDto update(AuthorDto authorDto) {
        authorDto.setId(authorRepository.update(authorMapper.getEntityFromModel(authorDto)).getId());
        return authorDto;
    }

    @Override
    public Boolean delete(Long id) {
        if (readAll().size() >= id) {
            authorRepository.delete(id);
            return true;
        }
        else {
            return false;
        }
    }
}