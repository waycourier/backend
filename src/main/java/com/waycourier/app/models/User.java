package com.waycourier.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column
	private String username;
	
	@Column
	private String firstName;
		
	@Column
	private String lastName;
		
	@Column
	private String password;
		
	@Column
	private String mobileNo;
		
	@Column
	private String email;

}
