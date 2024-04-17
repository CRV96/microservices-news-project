package com.microservices.news.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import static com.microservices.news.config.constants.WebsiteConstants.MODEL_PAGE_TITLE;

@Controller
public abstract class WebsiteAbstractController {

    @Value("${website.page.title}")
    private String pageTitle;

    @ModelAttribute(value = MODEL_PAGE_TITLE)
    public String getPageTitle(){
        return pageTitle;
    }

}
