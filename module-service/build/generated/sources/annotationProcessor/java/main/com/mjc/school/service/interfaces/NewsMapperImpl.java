package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.News;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:48:38+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News getModelFromEntity(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsModel.getId() );
        news.setTitle( newsModel.getTitle() );
        news.setContent( newsModel.getContent() );
        news.setCreateDate( newsModel.getCreateDate() );
        news.setLastUpdateDate( newsModel.getLastUpdateDate() );
        news.setAuthorId( newsModel.getAuthorId() );

        return news;
    }

    @Override
    public NewsModel getEntityFromModel(News news) {
        if ( news == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( news.getId() );
        newsModel.setTitle( news.getTitle() );
        newsModel.setContent( news.getContent() );
        newsModel.setCreateDate( news.getCreateDate() );
        newsModel.setLastUpdateDate( news.getLastUpdateDate() );
        newsModel.setAuthorId( news.getAuthorId() );

        return newsModel;
    }

    @Override
    public List<News> getModelListFromEntityList(List<NewsModel> newsModelList) {
        if ( newsModelList == null ) {
            return null;
        }

        List<News> list = new ArrayList<News>( newsModelList.size() );
        for ( NewsModel newsModel : newsModelList ) {
            list.add( getModelFromEntity( newsModel ) );
        }

        return list;
    }
}
