package com.waycourier.app.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageIndex;
import com.waycourier.app.models.User;
import com.waycourier.app.repository.IPackageIndexRepository;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.repository.IUserRepository;
import com.waycourier.app.to.PackageRequestTO;
import com.waycourier.app.utility.GeoUtil;

@Service
public class PackageService {
	
	private final IPackageRepository packageRepository;
	private final IUserRepository userRepository;
	private final IPackageIndexRepository packageEntityRepository;
	
	public PackageService(IPackageRepository packageRepository, IUserRepository userRepository,
			IPackageIndexRepository packageEntityRepository) {
		this.packageRepository = packageRepository;
		this.userRepository = userRepository;
		this.packageEntityRepository = packageEntityRepository;
	}

	// TODO:
	public void acceptPackageForDelivery(String username, int packageId) {
		User user = userRepository.findByUsername(username);
		
		// mark package for delviery by user
	}
	
	/* 
	 * main service to create a new Package entity and its corresponding Geo hash entity
	 * 
	 */
	public ResponseEntity<?> createPackage(PackageRequestTO requestTO) {
		Package pkg = new Package(requestTO);
		User user = userRepository.findByUsername(requestTO.username());
		pkg.setCreatedBy(user);
		
		pkg = packageRepository.save(pkg);

		String srcHash = GeoUtil.getGeoHash(pkg.getSource());
		String destHash = GeoUtil.getGeoHash(pkg.getDestination());

		PackageIndex pi = new PackageIndex(pkg, srcHash, destHash);
		packageEntityRepository.save(pi);
		
		// package created return id
		return ResponseEntity.status(HttpStatus.CREATED).body(pkg.getId());
	}
	
	// fetch package with packageId
	public ResponseEntity<?> findPackageById(int id) {
		Optional<Package> p = packageRepository.findById(id);

		if (p.isPresent()) {
			return ResponseEntity.ok(p.get());
		}
		
		return ResponseEntity.badRequest().body("No package found with id");
	}

	//Main service to update package details
	public Package updatePackage(PackageRequestTO pkg) {
		Optional<Package> updatedPkg = packageRepository.findById(pkg.packageId());
		
		if(!updatedPkg.isPresent()) {
			throw new HttpClientErrorException(
				HttpStatus.BAD_REQUEST, 
				"No package found with ID - " + pkg.packageId()
			);
		}

		Package p = updatedPkg.get();
		if(pkg.status() != null) {
			p.setStatus(pkg.status());
		}
		
		//TODO: Any other updating feature can be updated later
		
		return packageRepository.save(p);
	}
}
