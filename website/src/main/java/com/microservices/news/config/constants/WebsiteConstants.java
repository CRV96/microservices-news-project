package com.microservices.news.config.constants;

public interface WebsiteConstants {

    interface NytArticlesConstants{
        String NYT_MOST_POPULAR_URL = "/nyt/api/v1";
        String NYT_MOST_POPULAR_FACEBOOK_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/facebook";
        String NYT_MOST_POPULAR_EMAILED_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/emailed";
        String NYT_MOST_POPULAR_VIEWED_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/viewed";

        String NYT_EUREKA_CLIENT = "NEWS-SERVICE";
    }
}
