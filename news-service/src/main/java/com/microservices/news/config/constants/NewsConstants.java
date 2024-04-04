package com.microservices.news.config.constants;

public interface NewsConstants {

    String NYT_API_KEY_PARAM = "?api-key=";

    interface NYTConstants {
        String NYT_API_KEY_REFERENCE = "${new.york.times.api.key}";
        String NYT_MOST_POPULAR_ENDPOINT = "${new.york.times.most.popular.address}";
        String NYT_MOST_POPULAR_EMAILED_ENDPOINT = "${new.york.times.most.popular.address.emailed}";
        String NYT_MOST_POPULAR_FACEBOOK_ENDPOINT = "${new.york.times.most.popular.address.facebook}";
        String NYT_MOST_POPULAR_VIEWED_ENDPOINT = "${new.york.times.most.popular.address.viewed}";
        String URL_NYT_REST_CONTROLLER = "/nyt/api/v1";
        String URL_NYT_GET_MOST_RECENT_EMAIL = "/email";
        String URL_NYT_GET_MOST_RECENT_FACEBOOK = "/facebook";
        String URL_NYT_GET_MOST_RECENT_VIEWED = "/viewed";
    }

}
