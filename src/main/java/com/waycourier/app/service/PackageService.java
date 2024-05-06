package com.waycourier.app.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.repository.PackageEntityRepository;
import com.waycourier.app.to.PackageRequestTO;
import com.waycourier.app.utility.CustomIdGenerator;
import com.waycourier.app.utility.GeoUtil;

@Service
public class PackageService {
	@Autowired
	IPackageRepository pkgRepo;

	@Autowired
	PackageEntityRepository packageEntityRepository;
	
	@Autowired
	CustomIdGenerator customIdGenerator;
	
	//Main service to create a new Package entity and its corresponding Geohash entity
	public Package createPackage(PackageRequestTO pkg) {
		Package createdPackage = new Package();

		try {
			createdPackage.setPackageName(pkg.packageName());
			createdPackage.setPkgLatitude(pkg.location().lat());
			createdPackage.setPkgLongitude(pkg.location().lng());
			createdPackage.setPkgAddress(pkg.deliveryAddress());
			createdPackage.setPackageId(customIdGenerator.generatePackageId());
			createdPackage.setRecEndDate(new Date(253402300799000L));
			createdPackage.setCreatedAt(new Date());
			createdPackage.setPkgStatus(PackageStatus.CREATED);
			createdPackage.setFragile((pkg.fragile() != null && pkg.fragile()) ? true : false);
			createdPackage.setUsername(pkg.username());
			
			createdPackage = pkgRepo.save(createdPackage);

			String geohash = GeoUtil.getGeoHash(pkg.location());

			PackageEntity p = new PackageEntity(createdPackage.getPackageId(), createdPackage.getPackageName(), geohash);
			packageEntityRepository.save(p);
			
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return createdPackage;
	}
	
	//Main service packages with their packageId
	public Package findPackagesById(String id) {

		Optional<Package> pkg = pkgRepo.findByPackageId(id);

		if (pkg.isPresent())
			return pkg.get();
		else
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No package found with ID - " + id);

	}

	//Main service to update package details
	public Package updatePkgDetails(PackageRequestTO pkg) {
		Package updatedPkg = this.findPackagesById(pkg.packageId());
		
		if(updatedPkg == null)
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No package found with ID - " + pkg.packageId());
		try {
			if(pkg.pkgStatus() != null)
				updatedPkg.setPkgStatus(pkg.pkgStatus());
			
			if(pkg.fragile() != null)
				updatedPkg.setFragile(pkg.fragile());
			
			if(pkg.recptMobNo() != null)
				updatedPkg.setRecptMobNo(pkg.recptMobNo());
			
			//TODO: Any other updating feature can be updated later
			
			updatedPkg = pkgRepo.save(updatedPkg);
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return updatedPkg;
	}
}
