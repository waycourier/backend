package com.waycourier.app.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.waycourier.app.constants.PackageStatus;

@Document(collection = "packages")
public class Package {
	@Id
	String pkg_id;

	String pkgAddress;

	String recptMobNo;

	double pkgLongitude;

	double pkgLatitude;

	PackageStatus pkgStatus;

	Date recEndDate;

	Date createdAt;

	boolean fragile;
	
	String username;

	public String getPkg_id() {
		return pkg_id;
	}

	public void setPkg_id(String pkg_id) {
		this.pkg_id = pkg_id;
	}

	public String getPkgAddress() {
		return pkgAddress;
	}

	public void setPkgAddress(String pkgAddress) {
		this.pkgAddress = pkgAddress;
	}

	public String getRecptMobNo() {
		return recptMobNo;
	}

	public void setRecptMobNo(String recptMobNo) {
		this.recptMobNo = recptMobNo;
	}

	public double getPkgLongitude() {
		return pkgLongitude;
	}

	public void setPkgLongitude(double pkgLongitude) {
		this.pkgLongitude = pkgLongitude;
	}

	public double getPkgLatitude() {
		return pkgLatitude;
	}

	public void setPkgLatitude(double pkgLatitude) {
		this.pkgLatitude = pkgLatitude;
	}

	public PackageStatus getPkgStatus() {
		return pkgStatus;
	}

	public void setPkgStatus(PackageStatus pkgStatus) {
		this.pkgStatus = pkgStatus;
	}

	public Date getRecEndDate() {
		return recEndDate;
	}

	public void setRecEndDate(Date recEndDate) {
		this.recEndDate = recEndDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}