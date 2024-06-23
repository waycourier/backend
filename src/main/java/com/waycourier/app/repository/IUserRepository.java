package com.waycourier.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}
