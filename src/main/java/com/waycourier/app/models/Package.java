package com.waycourier.app.models;

import java.time.LocalDate;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.to.PackageRequestTO;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private String name;
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "lat", column = @Column(name = "src_lat")),
		@AttributeOverride(name = "lng", column = @Column(name = "src_lng"))
	})
	private Location source;
	
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "lat", column = @Column(name = "dest_lat")),
		@AttributeOverride(name = "lng", column = @Column(name = "dest_lng"))
	})
	private Location destination;
	private LocalDate recEndDate;
	private LocalDate createdAt;
	private boolean isFragile;

	private PackageStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User createdBy;

	// decorator
	public Package(PackageRequestTO requestTO) {
		this.id = requestTO.packageId();
		this.address = requestTO.deliveryAddress();
		this.name = requestTO.packageName();
		this.source = requestTO.source();
		this.destination = requestTO.destination();
		this.status = requestTO.status();
		this.recEndDate = LocalDate.of(9999, 1, 1);
		this.createdAt = LocalDate.now();
		this.isFragile = requestTO.isFragile() == null ? false : requestTO.isFragile();
	}
}