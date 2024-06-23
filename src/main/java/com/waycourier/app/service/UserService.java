package com.waycourier.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.models.User;
import com.waycourier.app.repository.IUserRepository;
import com.waycourier.app.to.UserRequestTO;

@Service
public class UserService {
	@Autowired
	IUserRepository userRepo;
	
	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */

	public User createNewUser(UserRequestTO user) {
		if(user.username() == null || user.password() == null || user.email() == null)
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username, Password and Email are mandatory.");
		
		//user.setPassword(/*passwordEncoder.encode(*/user.password());
		User newUser = new User();
		
		newUser.setFirstName(user.firstName());
		newUser.setLastName(user.lastName());
		newUser.setUsername(user.username());
		newUser.setEmail(user.email());
		newUser.setPassword(user.password());
		
		User createdUser = userRepo.save(newUser);

		if (createdUser == null)
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Unable to create user.");

		return createdUser;

	}
	
	public User getUserdetailsByUsername(String username) {
		if (username == null || !StringUtils.hasText(username))
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Username is mandatory.");
		
		User user = userRepo.findByUsername(username);
		
		if(user == null)
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No user found - "+username);
		
		return user;
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
