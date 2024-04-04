package com.microservices.news.service.impl;

import com.microservices.news.dto.NYTData;
import com.microservices.news.dto.NYTJsonData;
import com.microservices.news.service.NewYorkTimesService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static com.microservices.news.config.constants.NewsConstants.NYTConstants.*;
import static com.microservices.news.config.constants.NewsConstants.NYT_API_KEY_PARAM;

@Service
public class NewYorkTimesServiceImpl implements NewYorkTimesService {

    @Value(NYT_API_KEY_REFERENCE)
    private String nytApiKey;
    @Value(NYT_MOST_POPULAR_ENDPOINT)
    private String nytMostPopularEndpoint;
    @Value(NYT_MOST_POPULAR_EMAILED_ENDPOINT)
    private String nytMostPopularEmailedEndpoint;
    @Value(NYT_MOST_POPULAR_FACEBOOK_ENDPOINT)
    private String nytMostPopularFacebookEndpoint;
    @Value(NYT_MOST_POPULAR_VIEWED_ENDPOINT)
    private String nytMostPopularViewedEndpoint;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public List<NYTData> getMostRecentEmailedArticles() {
        NYTJsonData response = getNYTJsonDataResponse(nytMostPopularEmailedEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    @Override
    public List<NYTData> getMostRecentFacebookArticles() {
        NYTJsonData response = getNYTJsonDataResponse(nytMostPopularFacebookEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    @Override
    public List<NYTData> getMostRecentViewedArticles() {
        NYTJsonData response = getNYTJsonDataResponse(nytMostPopularViewedEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    private NYTJsonData getNYTJsonDataResponse(final String endpoint){
        final String url = nytMostPopularEndpoint + endpoint + NYT_API_KEY_PARAM + nytApiKey;
        NYTJsonData response = restTemplate().getForObject(url, NYTJsonData.class);

        return response;
    }
}
