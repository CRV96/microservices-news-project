package com.microservices.news.controller;

import com.microservices.news.config.constants.NewsConstants.NYTConstants;
import com.microservices.news.dto.NYTData;
import com.microservices.news.service.NewYorkTimesService;
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
    private NewYorkTimesService newYorkTimesService;

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_EMAIL)
    public List<NYTData> getMostRecentArticlesFromEmail(){
        return newYorkTimesService.getMostRecentEmailedArticles();
    }

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_FACEBOOK)
    public List<NYTData> getMostRecentArticlesFromFacebook(){
        return newYorkTimesService.getMostRecentFacebookArticles();
    }

    @GetMapping(NYTConstants.URL_NYT_GET_MOST_RECENT_VIEWED)
    public List<NYTData> getMostRecentArticlesFromViewed(){
        return newYorkTimesService.getMostRecentViewedArticles();
    }
}
