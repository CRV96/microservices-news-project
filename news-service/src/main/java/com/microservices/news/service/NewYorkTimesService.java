package com.microservices.news.service;

import com.microservices.news.dto.NYTData;

import java.util.List;

public interface NewYorkTimesService {

    List<NYTData> getMostRecentEmailedArticles();
    List<NYTData> getMostRecentFacebookArticles();
    List<NYTData> getMostRecentViewedArticles();
}
