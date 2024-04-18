package com.waycourier.app.models;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.waycourier.app.constants.PackageStatus;

@Document
public class Package {
	@Id
	String pkg_id;

	String pkgAddress;

	String recptMobNo;

	double pkgLognitude;

	double pkgLatitude;

	PackageStatus pkgStatus;

	Date recEndDate;

	LocalDateTime createdAt;

	boolean isFragile;

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

	public double getPkgLognitude() {
		return pkgLognitude;
	}

	public void setPkgLognitude(double pkgLognitude) {
		this.pkgLognitude = pkgLognitude;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isFragile() {
		return isFragile;
	}

	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}

}