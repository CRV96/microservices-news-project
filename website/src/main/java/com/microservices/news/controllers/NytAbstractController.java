package com.microservices.news.controllers;

import com.microservices.news.services.NytArticlesOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class NytAbstractController extends WebsiteAbstractController{

    @Autowired
    private NytArticlesOpenFeign nytArticlesOpenFeign;

    public NytArticlesOpenFeign getNytArticlesOpenFeign() {
        return nytArticlesOpenFeign;
    }

    public void setNytArticlesOpenFeign(NytArticlesOpenFeign nytArticlesOpenFeign) {
        this.nytArticlesOpenFeign = nytArticlesOpenFeign;
    }


}
