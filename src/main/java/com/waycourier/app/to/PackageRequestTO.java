package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;

public record PackageRequestTO(String packageId, String packageName, String deliveryAddress, Location location, String recptMobNo,
		PackageStatus pkgStatus ,String username, Boolean fragile) {
	
}