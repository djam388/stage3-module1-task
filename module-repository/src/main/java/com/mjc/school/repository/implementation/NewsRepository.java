package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasource.DataSource;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements com.mjc.school.repository.interfaces.NewsRepository {

    private final List<NewsModel> newsModelList = new ArrayList<>();
    private final DataSource dataSource = DataSource.getInstance();


    public NewsRepository() {
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

            newsModel.setId(newsModelList.size() + 1);
            newsModelList.add(newsModel);

        return newsModel;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        LocalDateTime dateTime = newsModelList.get((int) newsModel.getId()).getCreateDate();
        newsModelList.set((int) newsModel.getId(), newsModel);
        return newsModel;
    }

    @Override
    public Boolean delete(Long id) {
        newsModelList.remove(id.intValue());
        return true;
    }

    public void clear() {
        newsModelList.clear();
    }

}
