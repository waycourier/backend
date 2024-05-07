package com.waycourier.app.utility;

import com.waycourier.app.models.Package;
import com.waycourier.app.to.PackageResponseTO;

public class RequestResponseHandler {
	public static PackageResponseTO getPackageRespTO(Package pkg) {
		PackageResponseTO respTO = new PackageResponseTO();
		
		respTO.setFragile(pkg.isFragile());
		respTO.setPackageId(pkg.getPackageId());
		respTO.setPackageName(pkg.getPackageName());
		respTO.setPkgAddress(pkg.getPkgAddress());
		respTO.setPkgStatus(pkg.getPkgStatus());
		respTO.setRecptMobNo(pkg.getRecptMobNo());

		return respTO;
	}
}
