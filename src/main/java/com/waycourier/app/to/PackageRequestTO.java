package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;

public class UpdatePkgReqTO {
	Long pkgId;
	PackageStatus pkgStatus;
	public Long getPkgId() {
		return pkgId;
	}
	public void setPkgId(Long pkgId) {
		this.pkgId = pkgId;
	}
	public PackageStatus getPkgStatus() {
		return pkgStatus;
	}
	public void setPkgStatus(PackageStatus pkgStatus) {
		this.pkgStatus = pkgStatus;
	}
	
	
}
