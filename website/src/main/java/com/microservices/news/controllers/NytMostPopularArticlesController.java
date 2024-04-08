package com.microservices.news.controllers;

import com.microservices.news.config.constants.WebsiteConstants;
import com.microservices.news.dto.data.NytMostPopularData;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

import static com.microservices.news.config.constants.WebsiteConstants.*;
import static com.microservices.news.config.constants.WebsiteConstants.NytArticlesConstants.MODEL_ARTICLES;
import static com.microservices.news.config.constants.WebsiteConstants.NytArticlesConstants.NytMostPopularConstants.NYT_MOST_POPULAR_CATEGORY_PARAM;

@Controller
@RequestMapping(value = WebsiteConstants.URL_MOST_POPULAR)
public class NytMostPopularArticlesController extends NytAbstractController{

    @GetMapping()
    public String getMostPopularArticlesPage(@RequestParam(NYT_MOST_POPULAR_CATEGORY_PARAM) String category,
                                             Model model){
        if(ObjectUtils.isNotEmpty(category)){
            model.addAttribute(MODEL_ARTICLES, getArticlesBasedOnCategory(category));
        }

        model.addAttribute(MODEL_PAGE_BANNER_TITLE, "Most popular articles from " + category);

        return WebsiteConstants.NytArticlesConstants.HTML_PAGE;
    }

    private List<NytMostPopularData> getArticlesBasedOnCategory(String category) {
        if(category.equals(VAR_FACEBOOK)){
            return getNytArticlesOpenFeign().getMostPopularFacebookArticles();
        }else if(category.equals(VAR_EMAIL)){
            return getNytArticlesOpenFeign().getMostPopularEmailedArticles();
        }else if(category.equals(VAR_VIEWED)){
            return getNytArticlesOpenFeign().getMostPopularViewedArticles();
        }

        return Collections.emptyList();
    }


}
