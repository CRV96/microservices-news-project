package com.microservices.news.dto;

import lombok.Data;
import java.util.List;

@Data
public class NYTJsonData {
    private String status;
    private String copyright;
    private Integer num_results;
    private List<NYTData> results;
}
