package com.mjc.school.implementation;

import com.mjc.school.dto.NewsDto;
import com.mjc.school.service.News;
import com.mjc.school.mapper.NewsMapper;
import com.mjc.school.validator.HandledException;
import com.mjc.school.validator.Validator;
import org.mapstruct.factory.Mappers;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NewsService implements News {
    private final NewsRepository newsRepository = new NewsRepository();
    private final NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);
    private final Validator validator = new Validator();

    public NewsService () {

    }

    @Override
    public List<NewsDto> readAll() {
        return newsMapper.getModelListFromEntityList(newsRepository.readAll());
    }

    @Override
    public NewsDto readBy(Long id) {
        try {
            validator.validateId(id, readAll());
            return newsMapper.getModelFromEntity(newsRepository.readBy(id));
        }
        catch (HandledException handledException) {
            System.out.println(handledException.getMessage());
        }
    return null;

    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        try {
            validator.validateTitleLength(newsDto.getTitle());
            validator.validateContentLength(newsDto.getContent());
        } catch (HandledException handledException) {
            System.out.println(handledException.getMessage());
            return null;
        }
        setDateTime(newsDto, true);
        return newsMapper.getModelFromEntity(newsRepository.create(newsMapper.getEntityFromModel(newsDto)));
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        try {
            validator.validateNewsId(newsDto.getId(), readAll());
            validator.validateTitleLength(newsDto.getTitle());
            validator.validateContentLength(newsDto.getContent());
        } catch (HandledException handledException) {
            System.out.println(handledException.getMessage());
            return null;
        }
        setDateTime(newsDto, false);
        newsDto.setId(newsRepository.update(newsMapper.getEntityFromModel(newsDto)).getId());
        return newsDto;

    }

    @Override
    public Boolean delete(Long id) {

        try {
            validator.validateId(id, readAll());
            newsRepository.delete(id);
            return true;

        }
        catch (HandledException handledException) {
            System.out.println(handledException.getMessage());
            return false;
        }
    }

    private void setDateTime(NewsDto news, boolean newRecord) {
        if (newRecord) {
            LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            news.setCreateDate(localDateTime);
            news.setLastUpdateDate(localDateTime);
        }
        else {
            NewsDto originalNews = readBy(news.getId());
            news.setCreateDate(originalNews.getCreateDate());
            news.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        }
    }
}
