package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasources.DataSource;
import com.mjc.school.repository.interfaces.NewsRepositoryInterface;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements NewsRepositoryInterface {

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
        return newsModelList.get(id.intValue() - 1);
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        if (newsModelList.size() > 0) {
            newsModel.setId(newsModelList.size() + 1);
            newsModelList.add(newsModel);
        }
        else {
            newsModel.setId(1L);
            newsModelList.add(0, newsModel);
        }
        return newsModel;
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        LocalDateTime dateTime = newsModelList.get((int) newsModel.getId() - 1).getCreateDate();
        newsModelList.remove((int) newsModel.getId() - 1);
        newsModelList.add((int) newsModel.getId() - 1, newsModel);
        return newsModel;
    }

    @Override
    public Boolean delete(Long id) {
        newsModelList.remove(id.intValue() - 1);
        return true;
    }

    public void clear() {
        newsModelList.clear();
    }

}
