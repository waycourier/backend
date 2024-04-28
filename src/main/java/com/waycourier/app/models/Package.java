package com.waycourier.app.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.waycourier.app.constants.PackageStatus;

import jakarta.persistence.Id;

@Document(collection = "packages")
public class Package {
	@Id
	String _id;

	@Field(name = "pkg_id")
	String packageId;

	String pkgAddress;

	String packageName;

	String recptMobNo;

	double pkgLongitude;

	double pkgLatitude;

	PackageStatus pkgStatus;

	Date recEndDate;

	Date createdAt;

	boolean fragile;
	
	String username;

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String pkg_id) {
		this.packageId = pkg_id;
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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "Package [pkg_id=" + packageId + ", pkgAddress=" + pkgAddress + ", packageName=" + packageName
                + ", recptMobNo=" + recptMobNo + ", pkgLongitude=" + pkgLongitude + ", pkgLatitude=" + pkgLatitude
                + ", pkgStatus=" + pkgStatus + ", recEndDate=" + recEndDate + ", createdAt=" + createdAt + ", fragile="
                + fragile + ", username=" + username + "]";
    }

	
}