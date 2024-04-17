package com.microservices.news.dto.data;

import lombok.Data;

@Data
public class NytMostPopularMediaMetadata {
    private String url;
    private String format;
    private Integer height;
    private Integer width;
}
