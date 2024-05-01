package com.waycourier.app.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.waycourier.app.to.Location;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Document(collection = "package_geo_index")
public class PackageEntity {
    @Id
    private String id;
    private String packageId;
    private String packageName;
    private String geoHash;

    @Transient
    private Location location;

    protected PackageEntity() {
    }

    public PackageEntity(String packageId, String packageName, String geoHash) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.geoHash = geoHash;
    }
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getGeoHash() {
        return geoHash;
    }
    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return "PackageSearch [id=" + id + ", packageName=" + packageName + ", geoHash=" + geoHash + "]";
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
