package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.AuthorDto;

import java.util.List;

public interface AuthorServiceInterface {
    List<AuthorDto> readAll();
    AuthorDto readBy(Long id);
    AuthorDto create(AuthorDto authorDto);
    AuthorDto update(AuthorDto authorDto);
    Boolean delete(Long id);
}
