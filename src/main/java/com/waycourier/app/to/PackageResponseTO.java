package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.models.Location;
import com.waycourier.app.models.Package;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class PackageResponseTO {

	private int id;
	private String address;
	private String name;
	private String recptMobNo;
	private Location location;
	private PackageStatus status;
	private boolean fragile;


	public PackageResponseTO(Package pkg) {
		this.setFragile(pkg.isFragile());
		this.setId(pkg.getId());
		this.setName(pkg.getName());
		this.setAddress(pkg.getAddress());
		this.setStatus(pkg.getStatus());
		// respTO.setRecptMobNo(); TODO: need to map User to Package table
	}
}
