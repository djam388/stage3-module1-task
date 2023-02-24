package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.service.dto.News;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.interfaces.NewsServiceInterface;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NewsService implements NewsServiceInterface {
    private NewsRepository newsRepository = new NewsRepository();
    private NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);

    @Override
    public List<News> readAll() {
        return this.newsMapper.getModelListFromEntityList(newsRepository.readAll());
    }

    @Override
    public News readBy(long id) {
        return this.newsMapper.getModelFromEntity(newsRepository.readById(id));
    }

    @Override
    public News create(News news) {
        setDateTime(news, true);
        news = this.newsMapper.getModelFromEntity(newsRepository.create(this.newsMapper.getEntityFromModel(news)));
        return news;
    }

    @Override
    public News update(News news) {
        setDateTime(news, false);
        news.setId(newsRepository.update(this.newsMapper.getEntityFromModel(news)).getId());
        return news;
    }

    @Override
    public boolean delete(long id) {

        if (readAll().size() >= (int) id) {
            newsRepository.delete(id - 1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean clear() {
        newsRepository.clear();
        return true;
    }

    private void setDateTime(News news, boolean newRecord) {
        if (newRecord) {
            LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            news.setCreateDate(localDateTime);
            news.setLastUpdateDate(localDateTime);
        }
        else {
            News originalNews = readBy(news.getId() - 1);
            news.setCreateDate(originalNews.getCreateDate());
            news.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        }

    }
}
