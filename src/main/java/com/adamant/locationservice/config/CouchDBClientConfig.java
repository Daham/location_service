package com.adamant.locationservice.config;

import org.lightcouch.CouchDbClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDBClientConfig {

    @Bean
    public CouchDbClient couchDbClient(){
        return new CouchDbClient();
    }
}
