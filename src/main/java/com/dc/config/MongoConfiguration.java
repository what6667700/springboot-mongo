package com.dc.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class MongoConfiguration{

    @Autowired
    private MongoTemplate mongoTemplate;
//    @Bean
//    public MongoPageHelper mongoPageHelper() {
//        return new MongoPageHelper(mongoTemplate);
//    }

}
