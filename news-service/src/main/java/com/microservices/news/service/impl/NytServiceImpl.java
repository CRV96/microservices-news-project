package com.microservices.news.service.impl;

import com.microservices.news.dto.nyt.mostPopular.enums.NytMostPopularTypes;
import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;
import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularJsonData;
import com.microservices.news.repository.NytMostPopularRepository;
import com.microservices.news.service.NytService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static com.microservices.news.config.constants.NewsConstants.NYTConstants.*;
import static com.microservices.news.config.constants.NewsConstants.NYT_API_KEY_PARAM;

@Service
@Slf4j
public class NytServiceImpl implements NytService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private NytMostPopularRepository nytMostPopularRepository;
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
    public List<NytMostPopularData> getMostRecentEmailedArticlesFromNytAPI() {
        NytMostPopularJsonData response = getNYTJsonDataResponse(nytMostPopularEmailedEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    @Override
    public List<NytMostPopularData> getMostRecentFacebookArticlesFromNytAPI() {
        NytMostPopularJsonData response = getNYTJsonDataResponse(nytMostPopularFacebookEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    @Override
    public List<NytMostPopularData> getMostRecentViewedArticlesFromNytAPI() {
        NytMostPopularJsonData response = getNYTJsonDataResponse(nytMostPopularViewedEndpoint);

        if(ObjectUtils.isNotEmpty(response)){
            return response.getResults();
        }

        return Collections.emptyList();
    }

    @Override
    public void saveNytMostPopularDataInASpecificDatabase(List<NytMostPopularData> data, NytMostPopularTypes type) {
        data.stream().forEach(rec -> mongoTemplate.save(rec, type.name()));
    }

    @Override
    public List<NytMostPopularData> getNytMostPopularCollectionFromDatabase(NytMostPopularTypes type) {
        return mongoTemplate.findAll(NytMostPopularData.class, type.name());
    }

    private NytMostPopularJsonData getNYTJsonDataResponse(final String endpoint){
        final String url = nytMostPopularEndpoint + endpoint + NYT_API_KEY_PARAM + nytApiKey;
        NytMostPopularJsonData response = restTemplate().getForObject(url, NytMostPopularJsonData.class);

        return response;
    }
}
