package com.waycourier.app.to;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.models.Location;
import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageIndex;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class PackageIndexResponseTO {
    private int packageId;
    private String name;
	private Location source;
	private Location destination;
	
	public PackageIndexResponseTO(PackageIndex packageIndex) {
		this.packageId = packageIndex.getPackageId();
		this.name = packageIndex.getName();
		this.source = packageIndex.getSource();
		this.destination = packageIndex.getDestination();
	}
}
