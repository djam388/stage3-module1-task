package com.mjc.school.service;

import com.mjc.school.repository.NewsRepository;
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
    public List<NewsDto> readAllNews() {
        return this.newsMapper.getModelListFromEntityList(newsRepository.readAllNews());
    }

    @Override
    public NewsDto readById(long id) {
        return this.newsMapper.getModelFromEntity(newsRepository.readById(id));
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        setDateTime(newsDto, true);
        newsDto = this.newsMapper.getModelFromEntity(newsRepository.create(this.newsMapper.getEntityFromModel(newsDto)));
        return newsDto;
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        setDateTime(newsDto, false);
        newsDto.setId(newsRepository.update(this.newsMapper.getEntityFromModel(newsDto)).getId());
        return newsDto;
    }

    @Override
    public boolean delete(long id) {
        if (readAllNews().size() <= (int) id) {
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

    private void setDateTime(NewsDto newsDto, boolean newRecord) {
        if (newRecord) {
            LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            newsDto.setCreateDate(localDateTime);
            newsDto.setLastUpdateDate(localDateTime);
        }
        else {
            NewsDto originalNewsDto = readById(newsDto.getId() - 1);
            newsDto.setCreateDate(originalNewsDto.getCreateDate());
            newsDto.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        }

    }
}
