package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;

public record PackageRequestTO(Integer packageId, String packageName, String deliveryAddress, Location location,
		PackageStatus status, String username, Boolean fragile) {
	
}