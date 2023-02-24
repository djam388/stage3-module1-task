package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.News;
import com.mjc.school.service.dto.NewsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T22:57:15+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto getModelFromEntity(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( news.getId() );
        newsDto.setTitle( news.getTitle() );
        newsDto.setContent( news.getContent() );
        newsDto.setCreateDate( news.getCreateDate() );
        newsDto.setLastUpdateDate( news.getLastUpdateDate() );
        newsDto.setAuthorId( news.getAuthorId() );

        return newsDto;
    }

    @Override
    public News getEntityFromModel(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsDto.getId() );
        news.setTitle( newsDto.getTitle() );
        news.setContent( newsDto.getContent() );
        news.setCreateDate( newsDto.getCreateDate() );
        news.setLastUpdateDate( newsDto.getLastUpdateDate() );
        news.setAuthorId( newsDto.getAuthorId() );

        return news;
    }

    @Override
    public List<NewsDto> getModelListFromEntityList(List<News> newsList) {
        if ( newsList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsList.size() );
        for ( News news : newsList ) {
            list.add( getModelFromEntity( news ) );
        }

        return list;
    }
}
