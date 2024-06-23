package com.waycourier.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String username;
	
	// user info
	private String firstName;
	private String lastName;
	private String password;
	
	// contact details
	private String mobileNo;
	private String email;

	@OneToMany(mappedBy = "createdBy")
	private List<Package> packages;

	public User(String username, String firstName) {
		this.username = username;
		this.firstName = firstName;
	}
	
	
}
