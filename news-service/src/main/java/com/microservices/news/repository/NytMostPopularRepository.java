package com.microservices.news.repository;

import com.microservices.news.dto.nyt.mostPopular.data.NytMostPopularData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NytMostPopularRepository extends MongoRepository<NytMostPopularData, Long> {
}
