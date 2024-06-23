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
	private Location source;
	private Location destination;
	private boolean fragile;


	public PackageResponseTO(Package pkg) {
		this.setFragile(pkg.isFragile());
		this.setId(pkg.getId());
		this.setName(pkg.getName());
		this.setAddress(pkg.getAddress());
		this.setFragile(pkg.isFragile());
		this.setSource(pkg.getSource());
		this.setDestination(pkg.getDestination());
	}
}
