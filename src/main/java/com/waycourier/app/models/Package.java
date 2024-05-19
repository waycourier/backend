package com.waycourier.app.models;

import java.util.Date;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.to.Location;

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
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Id;

	@Column
	private String address;

	@Column
	private String name;

	@Column
	private Double latitude;

	@Column
	private Double longitude;

	@Column
	private PackageStatus status;

	@Column
	private Date recEndDate;

	@Column
	private  Date createdAt;

	@Column
	private boolean fragile;
	
	@Column
	private String username;
	
}