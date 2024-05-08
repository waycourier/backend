package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;

public class PackageResponseTO {
	private String packageId;

	private String pkgAddress;

	private String packageName;

	private String recptMobNo;

	/*
	 * private double pkgLongitude;
	 * 
	 * private double pkgLatitude;
	 */

	private PackageStatus pkgStatus;

	private boolean fragile;
	

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPkgAddress() {
		return pkgAddress;
	}

	public void setPkgAddress(String pkgAddress) {
		this.pkgAddress = pkgAddress;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getRecptMobNo() {
		return recptMobNo;
	}

	public void setRecptMobNo(String recptMobNo) {
		this.recptMobNo = recptMobNo;
	}


	public PackageStatus getPkgStatus() {
		return pkgStatus;
	}

	public void setPkgStatus(PackageStatus pkgStatus) {
		this.pkgStatus = pkgStatus;
	}

	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}

}
