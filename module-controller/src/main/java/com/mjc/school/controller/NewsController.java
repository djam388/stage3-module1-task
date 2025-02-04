package com.mjc.school.controller;

import com.mjc.school.dto.NewsDto;
import com.mjc.school.implementation.NewsService;

import java.util.List;

public class NewsController {
    NewsService newsService = new NewsService();
    private static NewsController INSTANCE;

    public static NewsController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewsController();
        }
        return INSTANCE;
    }

    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    public NewsDto readById(long id) {
        return newsService.readBy(id);
    }

    public NewsDto create(NewsDto news) {
        return newsService.create(news);
    }

    public NewsDto update(NewsDto news) {
        return newsService.update(news);
    }

    public boolean delete(long id) {
        return newsService.delete(id);
    }
}
