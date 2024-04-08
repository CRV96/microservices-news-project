package com.microservices.news.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NytMostPopularArticlesController {

    @GetMapping("/t")
    public String getArticle(){
        return "articlesPage";
    }
}
