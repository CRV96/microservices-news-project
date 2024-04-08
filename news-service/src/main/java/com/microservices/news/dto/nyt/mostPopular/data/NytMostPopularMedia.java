package com.microservices.news.dto.nyt.mostPopular.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NytMostPopularMedia {

    private String type;
    private String subtype;
    private String caption;
    private String copyright;

    @JsonProperty("media-metadata")
    private List<NytMostPopularMediaMetadata> mediaMetadata;
}
