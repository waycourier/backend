package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;

import com.waycourier.app.models.Location;

public record PackageRequestTO(
		Integer packageId,
		String packageName, 
		String deliveryAddress, 
		Location source, 
		Location destination,
		String username,
		PackageStatus status, 
		Boolean isFragile) {

}