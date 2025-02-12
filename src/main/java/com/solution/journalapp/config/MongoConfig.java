package com.solution.journalapp.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(
                "mongodb+srv://kunalsable9990:2Cr5csfBuMTzrCFK@cluster0.pbdsl.mongodb.net/journalDB?retryWrites=true&w=majority&appName=Cluster0"));
    }
}