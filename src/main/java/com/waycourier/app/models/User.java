package com.waycourier.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column(unique = true)
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
