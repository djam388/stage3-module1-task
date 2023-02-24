package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public interface NewsRepositoryInterface {
    List<NewsModel> readAll();
    NewsModel readById(long id);
    NewsModel create(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    boolean delete(long id);
}
