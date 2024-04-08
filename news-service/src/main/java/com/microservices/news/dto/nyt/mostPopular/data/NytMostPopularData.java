package com.microservices.news.dto.nyt.mostPopular.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class NytMostPopularData {
    @Id
    private Long id;

    private String uri;
    private String url;
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
    private List<NytMostPopularMedia> media;

}
