package com.waycourier.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name = "usr_usrname")
	String username;
	
	@Column(name="usr_pwd")
	String password;
	
	@Column(name="user_mob_no")
	String mobileNo;
	
	List<Package> packageList;
	
	
}
