package com.microservices.news.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NytMostPopularData {

    private String uri;
    private String url;
    private String published_date;
    private String updated;
    private String section;
    private String byline;
    private String title;
    @JsonProperty("abstract")
    private String abstractTitle;
    @JsonProperty("media")
    private List<NytMostPopularMedia> media;
}
