package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.service.dto.NewsDto;
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
    public List<NewsDto> readAll() {
        return this.newsMapper.getModelListFromEntityList(newsRepository.readAll());
    }

    @Override
    public NewsDto readBy(long id) {
        return this.newsMapper.getModelFromEntity(newsRepository.readBy(id));
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        setDateTime(newsDto, true);
        return this.newsMapper.getModelFromEntity(newsRepository.create(this.newsMapper.getEntityFromModel(newsDto)));

    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        setDateTime(newsDto, false);
        newsDto.setId(newsRepository.update(this.newsMapper.getEntityFromModel(newsDto)).getId());
        return newsDto;
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

    private void setDateTime(NewsDto news, boolean newRecord) {
        if (newRecord) {
            LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            news.setCreateDate(localDateTime);
            news.setLastUpdateDate(localDateTime);
        }
        else {
            NewsDto originalNews = readBy(news.getId() - 1);
            news.setCreateDate(originalNews.getCreateDate());
            news.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        }

    }
}
