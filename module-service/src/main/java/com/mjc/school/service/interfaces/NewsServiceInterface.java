package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.News;

import java.util.List;

public interface NewsServiceInterface {

    List<News> readAll();
    News readBy(long id);
    News create(News news);
    News update(News news);
    boolean delete(long id);
}
