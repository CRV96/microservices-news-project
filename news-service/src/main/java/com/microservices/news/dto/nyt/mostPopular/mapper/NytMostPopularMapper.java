package com.microservices.news.dto.nyt.mostPopular.mapper;

import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NytMostPopularMapper {

    NytMostPopularMapper NytMostPopularMapper = Mappers.getMapper(NytMostPopularMapper.class);

//    List<NytMostPopularEmailedDocument> mapListToEmailedDocuments(List<NytMostPopularData> source);
//    List<NytMostPopularFacebookDocument> mapListToFacebookDocuments(List<NytMostPopularData> source);
//    List<NytMostPopularViewedDocument> mapListToViewedDocuments(List<NytMostPopularData> source);

}
