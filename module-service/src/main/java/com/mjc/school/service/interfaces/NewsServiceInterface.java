package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public interface NewsServiceInterface {

    List<NewsDto> readAll();
    NewsDto readBy(long id);
    NewsDto create(NewsDto newsDto);
    NewsDto update(NewsDto newsDto);
    boolean delete(long id);
}
