package com.microservices.news.dto.nyt.mostPopular.data;

import lombok.Data;
import java.util.List;

@Data
public class NytMostPopularJsonData {
    private String status;
    private String copyright;
    private Integer num_results;
    private List<NytMostPopularData> results;
}
