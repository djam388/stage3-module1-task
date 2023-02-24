package com.mjc.school.repository.implementation;

import com.mjc.school.repository.datasources.Datasource;
import com.mjc.school.repository.interfaces.NewsRepositoryInterface;
import com.mjc.school.repository.model.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements NewsRepositoryInterface {

    private List<NewsModel> newsModelList = new ArrayList<>();

    public NewsRepository() {
        newsModelList.addAll(Datasource.getInstance().getNewsAll());
    }
    @Override
    public List<NewsModel> readAll() {
        return newsModelList;
    }

    @Override
    public NewsModel readById(long id) {
        return newsModelList.get((int) id - 1);
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
    public boolean delete(long id) {
        newsModelList.remove((int) id);
        return true;
    }

    public boolean clear() {
        newsModelList.clear();
        return true;
    }

}
