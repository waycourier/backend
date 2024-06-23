package com.waycourier.app.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
    private int id;
    private int packageId;
    private String name;
    private String srcGeoHash;
    private String destGeoHash;
    
    @Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "lat", column = @Column(name = "src_lat")),
		@AttributeOverride(name = "lng", column = @Column(name = "src_lng"))
	})
	private Location source;
    
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "lat", column = @Column(name = "dest_lat")),
		@AttributeOverride(name = "lng", column = @Column(name = "dest_lng"))
	})
	private Location destination;

    public PackageIndex(Package pkg, String srcGeoHash, String destGeoHash) {
        this.packageId = pkg.getId();
        this.name = pkg.getName();
        this.source = pkg.getSource();
        this.destination = pkg.getDestination();
        this.srcGeoHash = srcGeoHash;
        this.destGeoHash = destGeoHash;
    }
}
