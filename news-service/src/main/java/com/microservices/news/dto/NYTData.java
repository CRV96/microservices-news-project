package com.microservices.news.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NYTData {
    private String uri;
    private String url;
    private Long id;
    private Long asset_id;
    private String source;
    private String published_date;
    private String updated;
    private String section;
    private String nytdsection;
    private String adx_keywords;
    private String byline;
    private String type;
    private String title;
    @JsonProperty("abstract")
    private String abstractTitle;
    @JsonProperty("media")
    private List<NYTMedia> media;

}
