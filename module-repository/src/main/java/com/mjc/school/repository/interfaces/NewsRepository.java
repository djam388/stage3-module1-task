package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public interface NewsRepository {
    List<NewsModel> readAll();
    NewsModel readBy(Long id);
    NewsModel create(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    Boolean delete(Long id);
}
