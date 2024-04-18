package com.waycourier.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waycourier.app.models.Package;
import com.waycourier.app.repository.IPackageRepository;

@Service
public class PackageService {
	@Autowired
	IPackageRepository pkgRepo;
	
	public Package createPackage(Package pkg) {
		Package createdPackage = null;
		try {
			createdPackage = pkgRepo.save(pkg);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return createdPackage;
	}
	
	
	public Package findPackagesById(String id) {
		try {
			Optional<Package> pkg = pkgRepo.findById(id);
			
			if(pkg.isPresent())
				return pkg.get();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
