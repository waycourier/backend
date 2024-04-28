package com.waycourier.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.repository.PackageEntityRepository;
import com.waycourier.app.to.PackageDataTO;
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
	
	public Package createPackage(PackageDataTO pkg) {
		Package createdPackage = new Package();
		Calendar calendar = Calendar.getInstance();
		calendar.set(9999, 0, 1);
		
		try {
			createdPackage.setPackageName(pkg.packageName());
			createdPackage.setPkgLatitude(pkg.location().lat());
			createdPackage.setPkgLongitude(pkg.location().lng());

			createdPackage.setPackageId(customIdGenerator.generatePackageId());
			createdPackage.setRecEndDate(calendar.getTime());
			createdPackage.setCreatedAt(new Date());
			
			createdPackage = pkgRepo.save(createdPackage);

			String geohash = GeoUtil.getGeoHash(pkg.location());

			PackageEntity p = new PackageEntity(createdPackage.getPackageId(), createdPackage.getPackageName(), geohash);
			packageEntityRepository.save(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return createdPackage;
	}
	
	
	public Package findPackagesById(String id) {

		Optional<Package> pkg = pkgRepo.findByPackageId(id);

		if (pkg.isPresent())
			return pkg.get();
		else
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No package found with ID - " + id);

	}
}
