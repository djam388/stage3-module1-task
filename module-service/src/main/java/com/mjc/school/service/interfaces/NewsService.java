package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public interface NewsService {

    List<NewsDto> readAll();
    NewsDto readBy(Long id);
    NewsDto create(NewsDto newsDto);
    NewsDto update(NewsDto newsDto);
    Boolean delete(Long id);
}
