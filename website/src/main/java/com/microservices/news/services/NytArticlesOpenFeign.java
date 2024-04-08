package com.microservices.news.services;

import com.microservices.news.config.constants.WebsiteConstants.NytArticlesConstants;
import com.microservices.news.dto.data.NytMostPopularData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = NytArticlesConstants.NYT_EUREKA_CLIENT)
public interface NytArticlesOpenFeign {

    @GetMapping(value = NytArticlesConstants.NYT_MOST_POPULAR_VIEWED_ARTICLES_URL)
    List<NytMostPopularData> getMostPopularViewedArticles();

    @GetMapping(value = NytArticlesConstants.NYT_MOST_POPULAR_FACEBOOK_ARTICLES_URL)
    List<NytMostPopularData> getMostPopularFacebookArticles();

    @GetMapping(value = NytArticlesConstants.NYT_MOST_POPULAR_EMAILED_ARTICLES_URL)
    List<NytMostPopularData> getMostPopularEmailedArticles();

}
