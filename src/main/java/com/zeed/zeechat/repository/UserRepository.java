package com.zeed.zeechat.repository;

import com.zeed.zeechat.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findTopByUsername(String username);

    User findTopByUsernameOrEmail(String username, String email);

}
