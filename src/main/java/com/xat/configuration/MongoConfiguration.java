package com.xat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {
	@Bean
	public MongoClient createConnection() {
		//You should put your mongo ip here
		return new MongoClient("localhost:27017");
	}
}
