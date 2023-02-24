package com.mjc.shool.contoller;

import com.mjc.school.service.dto.News;
import com.mjc.school.service.implementation.NewsService;

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

    public List<News> readAll() {
        return newsService.readAll();
    }

    public News readBy(long id) {
        return newsService.readBy(id);
    }

    public News create(News news) {
        return newsService.create(news);
    }

    public News update(News news) {
        return newsService.update(news);
    }

    public boolean delete(long id) {
        return newsService.delete(id);
    }
}
