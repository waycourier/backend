package com.waycourier.app.models;

import com.waycourier.app.to.Location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
@Table(name = "package_index")
public class PackageIndex {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int packageId;

    @Column
    private String Name;

    @Column
    private String geoHash;

    @Column
	private Double latitude;

	@Column
	private Double longitude;

    public PackageIndex(int packageId, String packageName, String geoHash) {
        this.packageId = packageId;
        this.Name = packageName;
        this.geoHash = geoHash;
    }

    public PackageIndex(Package pkg, String geoHash) {
        this.packageId = pkg.getId();
        this.Name = pkg.getName();
        this.geoHash = geoHash;
    }
}
