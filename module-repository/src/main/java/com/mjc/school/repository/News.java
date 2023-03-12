package com.mjc.school.repository;

import com.mjc.school.model.NewsModel;

import java.util.List;

public interface News {
    List<NewsModel> readAll();
    NewsModel readBy(Long id);
    NewsModel create(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    Boolean delete(Long id);
}
