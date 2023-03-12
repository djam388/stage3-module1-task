package com.mjc.school.service;

import com.mjc.school.dto.AuthorDto;

import java.util.List;

public interface Author {
    List<AuthorDto> readAll();
    AuthorDto readBy(Long id);
    AuthorDto create(AuthorDto authorDto);
    AuthorDto update(AuthorDto authorDto);
    Boolean delete(Long id);
}
