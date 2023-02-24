package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.model.News;

import java.util.List;

public interface NewsRepositoryInterface {
    List<News> readAllNews();
    News readById(long id);
    News create(News news);
    News update(News news);
    boolean delete(long id);
}
