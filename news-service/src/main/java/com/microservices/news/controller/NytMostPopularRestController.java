package com.microservices.news.controller;

import com.microservices.news.config.constants.NewsConstants.NYTConstants;
import com.microservices.news.dto.nyt.mostPopular.enums.NytMostPopularTypes;
import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;
import com.microservices.news.service.NytService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = NYTConstants.URL_NYT_REST_CONTROLLER)
public class NytMostPopularRestController {

    @Autowired
    private NytService newYorkTimesService;

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_EMAIL)
    public List<NytMostPopularData> getMostRecentArticlesFromEmail(){
        return newYorkTimesService.getNytMostPopularCollectionFromDatabase(NytMostPopularTypes.NYT_MOST_POPULAR_EMAILED);
    }

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_FACEBOOK)
    public List<NytMostPopularData> getMostRecentArticlesFromFacebook(){
        return newYorkTimesService.getNytMostPopularCollectionFromDatabase(NytMostPopularTypes.NYT_MOST_POPULAR_FACEBOOK);
    }

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_VIEWED)
    public List<NytMostPopularData> getMostRecentArticlesFromViewed(){
        return newYorkTimesService.getNytMostPopularCollectionFromDatabase(NytMostPopularTypes.NYT_MOST_POPULAR_VIEWED);
    }
}
