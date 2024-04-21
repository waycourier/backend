package com.waycourier.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.User;
import com.waycourier.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	ResponseEntity<?> createUser(@RequestBody User userInp){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userInp));
	}
	
	@GetMapping("/{username}")
	ResponseEntity<?> getUserByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.getUserdetailsByUsername(username));
	}
	
	@PostMapping("/updateUser")
	ResponseEntity<?> updateUser(@RequestBody User userInp){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUserDetails(userInp));
	}
	
	@DeleteMapping("/{username}")
	ResponseEntity<?> deleteUser(@PathVariable String username){
		return ResponseEntity.ok(userService.deleteUserByUsername(username));
	}
}
