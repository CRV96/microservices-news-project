package com.microservices.news.dto.nyt.mostPopular.data;

import lombok.Data;

@Data
public class NytMostPopularMediaMetadata {
    private String url;
    private String format;
    private Integer height;
    private Integer width;
}
