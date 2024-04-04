package com.microservices.news.dto;

import lombok.Data;

@Data
public class NYTMediaMetadata {
    private String url;
    private String format;
    private Integer height;
    private Integer width;
}
