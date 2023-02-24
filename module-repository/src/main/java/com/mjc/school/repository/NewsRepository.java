package com.mjc.school.repository;

import com.mjc.school.repository.datasources.Datasource;
import com.mjc.school.repository.interfaces.NewsRepositoryInterface;
import com.mjc.school.repository.model.News;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements NewsRepositoryInterface {

    private List<News> newsList = new ArrayList<>();

    public NewsRepository() {
        newsList.addAll(Datasource.getInstance().getNewsAll());
    }
    @Override
    public List<News> readAllNews() {
        return newsList;
    }

    @Override
    public News readById(long id) {
        return newsList.get((int) id - 1);
    }

    @Override
    public News create(News news) {
        if (newsList.size() > 0) {
            news.setId(newsList.size() + 1);
            newsList.add(news);
        }
        else {
            news.setId(1L);
            newsList.add(0, news);
        }
        return news;
    }

    @Override
    public News update(News news) {
        LocalDateTime dateTime = newsList.get((int) news.getId() - 1).getCreateDate();
        newsList.remove((int) news.getId() - 1);
        newsList.add((int) news.getId() - 1, news);
        return news;
    }

    @Override
    public boolean delete(long id) {
        newsList.remove((int) id);
        return true;
    }

    public boolean clear() {
        newsList.clear();
        return true;
    }

}
