package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public interface NewsServiceInterface {

    List<NewsDto> readAllNews();
    NewsDto readById(long id);
    NewsDto create(NewsDto newsDto);
    NewsDto update(NewsDto newsDto);
    boolean delete(long id);
}
