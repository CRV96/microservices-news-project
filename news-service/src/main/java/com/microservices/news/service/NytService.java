package com.microservices.news.service;

import com.microservices.news.dto.nyt.mostPopular.enums.NytMostPopularTypes;
import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;

import java.util.List;

public interface NytService {

    List<NytMostPopularData> getMostRecentEmailedArticlesFromNytAPI();
    List<NytMostPopularData> getMostRecentFacebookArticlesFromNytAPI();
    List<NytMostPopularData> getMostRecentViewedArticlesFromNytAPI();
    void saveNytMostPopularDataInASpecificDatabase(final List<NytMostPopularData> dataList, final NytMostPopularTypes type);
    List<NytMostPopularData> getNytMostPopularCollectionFromDatabase(final NytMostPopularTypes types);
}
