package com.zeed.zeechat.repository;

import com.zeed.zeechat.entities.OauthClientDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OauthClientDetailsRepository extends MongoRepository <OauthClientDetails, String> {

    OauthClientDetails findTopByClientId(String clientId);

}
