package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.document.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findOneByName(String name);
}
