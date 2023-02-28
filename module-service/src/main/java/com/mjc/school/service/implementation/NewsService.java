package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.interfaces.NewsServiceInterface;
import com.mjc.school.service.validator.Validator;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NewsService implements NewsServiceInterface {
    private final NewsRepository newsRepository = new NewsRepository();
    private final NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);



    private final Validator validator = new Validator();
    private static NewsService INSTANCE;

    private NewsService () {

    }

    public static NewsService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewsService();
        }
        return INSTANCE;
    }

    @Override
    public List<NewsDto> readAll() {
        return this.newsMapper.getModelListFromEntityList(newsRepository.readAll());
    }

    @Override
    public NewsDto readBy(Long id) {
        if (validator.validateId(id)) {
            return this.newsMapper.getModelFromEntity(newsRepository.readBy(id));
        }
        return null;
    }

    @Override
    public NewsDto create(NewsDto newsDto) {

        setDateTime(newsDto, true);

        if (validateScope(newsDto)) {
            return this.newsMapper.getModelFromEntity(newsRepository.create(this.newsMapper.getEntityFromModel(newsDto)));
        }
        else {
            return null;
        }
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        setDateTime(newsDto, false);
        if (validateScope(newsDto)) {
            newsDto.setId(newsRepository.update(this.newsMapper.getEntityFromModel(newsDto)).getId());
            return newsDto;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean delete(Long id) {

        if (validator.validateId(id)) {
            newsRepository.delete(id);
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

    private Boolean validateScope(NewsDto newsDto) {
        Boolean validated = false;
        if (validator.validateNewsId(newsDto.getId())) {
            validated = true;
        }
        if (validator.validateTitleLength(newsDto.getTitle()) && validated) {
            validated = true;
        }
        if (validator.validateContentLength(newsDto.getContent()) && validated) {
            validated = true;
        }
        if (validator.validateAuthorId(newsDto.getAuthorId())) {
            validated = true;
        }
        else {
            validated = false;
        }
        return  validated;
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
