package com.zeed.zeechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.zeed.zeechat.repository")
public class ZeechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeechatApplication.class, args);
	}

}

