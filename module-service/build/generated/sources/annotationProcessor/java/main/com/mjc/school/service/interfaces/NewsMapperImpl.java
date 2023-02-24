package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.News;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:35:04+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News getModelFromEntity(com.mjc.school.repository.model.News news) {
        if ( news == null ) {
            return null;
        }

        News news1 = new News();

        news1.setId( news.getId() );
        news1.setTitle( news.getTitle() );
        news1.setContent( news.getContent() );
        news1.setCreateDate( news.getCreateDate() );
        news1.setLastUpdateDate( news.getLastUpdateDate() );
        news1.setAuthorId( news.getAuthorId() );

        return news1;
    }

    @Override
    public com.mjc.school.repository.model.News getEntityFromModel(News news) {
        if ( news == null ) {
            return null;
        }

        com.mjc.school.repository.model.News news1 = new com.mjc.school.repository.model.News();

        news1.setId( news.getId() );
        news1.setTitle( news.getTitle() );
        news1.setContent( news.getContent() );
        news1.setCreateDate( news.getCreateDate() );
        news1.setLastUpdateDate( news.getLastUpdateDate() );
        news1.setAuthorId( news.getAuthorId() );

        return news1;
    }

    @Override
    public List<News> getModelListFromEntityList(List<com.mjc.school.repository.model.News> newsList) {
        if ( newsList == null ) {
            return null;
        }

        List<News> list = new ArrayList<News>( newsList.size() );
        for ( com.mjc.school.repository.model.News news : newsList ) {
            list.add( getModelFromEntity( news ) );
        }

        return list;
    }
}
