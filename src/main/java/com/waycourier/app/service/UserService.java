package com.waycourier.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.models.User;
import com.waycourier.app.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	IUserRepository userRepo;
	
	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */

	public User createNewUser(User user) {
		if(user.getUsername() == null || user.getPassword() == null || user.getEmail() == null)
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username, Password and Email are mandatory.");
		
		user.setPassword(/*passwordEncoder.encode(*/user.getPassword());
		
		User createdUser = userRepo.save(user);

		if (createdUser == null)
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Unable to create user.");

		return createdUser;

	}
	
	public User getUserdetailsByUsername(String username) {
		if (username == null || !StringUtils.hasText(username))
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username is mandatory.");
		
		List<User> user = userRepo.findByUsername(username);
		
		if(user == null || user.isEmpty())
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No user found - "+username);
		
		return user.get(0);
	}

	public User updateUserDetails(User userInp) {
		if(userInp == null || userInp.getUsername() == null)
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username is mandatory.");
		
		User fetchedUser = this.getUserdetailsByUsername(userInp.getUsername());
		
		if(userInp.getEmail() != null)
			fetchedUser.setEmail(userInp.getEmail());
		
		if(userInp.getMobileNo() != null)
			fetchedUser.setMobileNo(userInp.getMobileNo());
		
		if(userInp.getPassword() != null)
			fetchedUser.setPassword(userInp.getPassword());
		
		return userRepo.save(fetchedUser);

	}

	public Boolean deleteUserByUsername(String username) {
		if(username == null || !StringUtils.hasText(username))
			new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username is mandatory.");
		
		User fetchedUser = this.getUserdetailsByUsername(username);
		
		userRepo.delete(fetchedUser);
		
		return true;
	}
}
