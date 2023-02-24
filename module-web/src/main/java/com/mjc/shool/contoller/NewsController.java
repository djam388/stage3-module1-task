package com.mjc.shool.contoller;

import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDto;

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

    public List<NewsDto> readAllNews() {
        return newsService.readAllNews();
    }

    public NewsDto readById(long id) {
        return newsService.readById(id);
    }

    public NewsDto create(NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    public NewsDto update(NewsDto newsDto) {
        return newsService.update(newsDto);
    }

    public boolean delete(long id) {
        return newsService.delete(id);
    }
}
