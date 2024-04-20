package com.waycourier.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.models.Package;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.utility.CustomIdGenerator;

@Service
public class PackageService {
	@Autowired
	IPackageRepository pkgRepo;
	
	@Autowired
	CustomIdGenerator customIdGenerator;
	
	public Package createPackage(Package pkg) {
		Package createdPackage = null;
		Calendar calendar = Calendar.getInstance();
		calendar.set(9999, 0, 1);
		
		try {
			pkg.setPkg_id(customIdGenerator.generatePackageId());
			pkg.setRecEndDate(calendar.getTime());
			pkg.setCreatedAt(new Date());
			
			createdPackage = pkgRepo.save(pkg);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return createdPackage;
	}
	
	
	public Package findPackagesById(String id) {

		Optional<Package> pkg = pkgRepo.findById(id);

		if (pkg.isPresent())
			return pkg.get();
		else
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No package found with ID - " + id);

	}
}
