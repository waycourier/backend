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
	private Integer Id;
	private String address;
	private String name;

	private Double latitude;
	private Double longitude;

	private PackageStatus status;

	private Date recEndDate;

	private  Date createdAt;
	
	private boolean fragile;

	private String username;
	
}