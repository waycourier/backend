package com.waycourier.app.models;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import com.waycourier.app.constants.PackageStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "packages")
public class Package {
	@Id
	@UuidGenerator
	String pkg_id;

	@Column(name = "pkg_addrs")
	String pkgAddress;

	@Column(name = "pkg_recpt_mob_no")
	String recptMobNo;

	@Column(name = "pkg_long")
	double pkgLognitude;

	@Column(name = "pkg_latd")
	double pkgLatitude;

	@Column(name = "pkg_status")
	PackageStatus pkgStatus;

	@Column(name = "pkg_rec_end_date")
	Date recEndDate;

	@Column(name = "pkg_createdAt")
	LocalDateTime createdAt;

	@Column(name = "pkg_frgl")
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