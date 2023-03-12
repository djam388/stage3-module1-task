package com.mjc.school.mapper;

import com.mjc.school.dto.NewsDto;
import com.mjc.school.model.NewsModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T22:56:13+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto getModelFromEntity(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( newsModel.getId() );
        newsDto.setTitle( newsModel.getTitle() );
        newsDto.setContent( newsModel.getContent() );
        newsDto.setCreateDate( newsModel.getCreateDate() );
        newsDto.setLastUpdateDate( newsModel.getLastUpdateDate() );
        newsDto.setAuthorId( newsModel.getAuthorId() );

        return newsDto;
    }

    @Override
    public NewsModel getEntityFromModel(NewsDto news) {
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
    public List<NewsDto> getModelListFromEntityList(List<NewsModel> newsModelList) {
        if ( newsModelList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsModelList.size() );
        for ( NewsModel newsModel : newsModelList ) {
            list.add( getModelFromEntity( newsModel ) );
        }

        return list;
    }
}
