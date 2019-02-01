package com.zeed.zeechat.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.db.host:127.0.0.1}")
    private String mongoHost;

    @Value("${mongo.db.port:27017}")
    private Integer mongoPort;

    @Value("${mongo.db.collection:zeechat}")
    private String mongoCollection;
  
    @Override
    protected String getDatabaseName() {
        return mongoCollection;
    }
  
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, mongoPort);
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "com.zeed.zeechat.entities";
    }
}
