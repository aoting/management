package com.xat.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xat.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(final String username);
	public User findById(final String id);
}
