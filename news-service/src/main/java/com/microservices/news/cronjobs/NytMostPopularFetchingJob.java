package com.microservices.news.cronjobs;

import com.microservices.news.dto.nyt.mostPopular.enums.NytMostPopularTypes;
import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;
import com.microservices.news.service.NytService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
public class NytMostPopularFetchingJob {

    @Autowired
    private NytService nytService;

    /**
     * Execute every day at 12:00 AM and on startup
     */
    @Scheduled(cron = "0 0 0 * * *")
    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public void fetchMostPopularFacebookPosts(){
        List<NytMostPopularData> facebookResponse = nytService.getMostRecentFacebookArticlesFromNytAPI();
        List<NytMostPopularData> viewedResponse = nytService.getMostRecentViewedArticlesFromNytAPI();
        List<NytMostPopularData> emailedResponse = nytService.getMostRecentEmailedArticlesFromNytAPI();

        log.info("Inserting in mongo facebook " + facebookResponse.size() + " records...viewed " + viewedResponse.size()
        + " records... emailed " + emailedResponse.size() + " records...");

        nytService.saveNytMostPopularDataInASpecificDatabase(facebookResponse, NytMostPopularTypes.NYT_MOST_POPULAR_FACEBOOK);
        nytService.saveNytMostPopularDataInASpecificDatabase(viewedResponse, NytMostPopularTypes.NYT_MOST_POPULAR_VIEWED);
        nytService.saveNytMostPopularDataInASpecificDatabase(emailedResponse, NytMostPopularTypes.NYT_MOST_POPULAR_EMAILED);

        log.info("fetchMostPopularFacebookPosts has been run with success...");
    }

}
