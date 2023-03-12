package com.mjc.school.service;

import com.mjc.school.dto.NewsDto;

import java.util.List;

public interface News {

    List<NewsDto> readAll();
    NewsDto readBy(Long id);
    NewsDto create(NewsDto newsDto);
    NewsDto update(NewsDto newsDto);
    Boolean delete(Long id);
}
