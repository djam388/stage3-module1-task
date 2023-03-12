package com.mjc.school.implementation;

import com.mjc.school.datasource.DataSource;
import com.mjc.school.repository.News;
import com.mjc.school.model.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements News {

    private final List<NewsModel> newsModelList = new ArrayList<>();


    public NewsRepository() {
        DataSource dataSource = DataSource.getInstance();
        newsModelList.addAll(dataSource.getNewsAll());
    }
    @Override
    public List<NewsModel> readAll() {
        return newsModelList;
    }

    @Override
    public NewsModel readBy(Long id) {
        return newsModelList.get(id.intValue());
    }

    @Override
    public NewsModel create(NewsModel newsModel) {

            newsModel.setId(newsModelList.size());
            newsModelList.add(newsModel);

        return newsModel;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        newsModelList.set((int) newsModel.getId(), newsModel);
        return newsModel;
    }

    @Override
    public Boolean delete(Long id) {
        newsModelList.remove(id.intValue());
        return true;
    }

}
