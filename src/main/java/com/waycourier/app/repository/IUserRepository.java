package com.waycourier.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.waycourier.app.models.User;
import java.util.List;


public interface IUserRepository extends MongoRepository<User, String> {
	List<User> findByUsername(String username);
}
