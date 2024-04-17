package com.microservices.news.config.constants;

public interface WebsiteConstants {
    String URL_MOST_POPULAR = "/mp";
    String VAR_FACEBOOK = "facebook";
    String VAR_EMAIL = "email";
    String VAR_VIEWED = "viewed";
    String MODEL_PAGE_TITLE = "pageTitle";
    String MODEL_PAGE_BANNER_TITLE = "bannerTitle";

    interface NytArticlesConstants{
        String MODEL_ARTICLES = "articles";
        String NYT_MOST_POPULAR_URL = "/nyt/api/v1";
        String NYT_MOST_POPULAR_FACEBOOK_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/facebook";
        String NYT_MOST_POPULAR_EMAILED_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/email";
        String NYT_MOST_POPULAR_VIEWED_ARTICLES_URL = NYT_MOST_POPULAR_URL + "/viewed";
        String NYT_EUREKA_CLIENT = "NEWS-SERVICE";
        String HTML_PAGE = "articlesPage";


        interface NytMostPopularConstants{
            String NYT_MOST_POPULAR_CATEGORY_PARAM = "category";

        }
    }
}
