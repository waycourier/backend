package com.waycourier.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.User;
import java.util.List;


public interface IUserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
}
