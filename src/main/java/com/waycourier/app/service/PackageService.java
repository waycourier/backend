package com.waycourier.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.waycourier.app.constants.PackageStatus;
import com.waycourier.app.models.DeliveryRecord;
import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageIndex;
import com.waycourier.app.models.User;
import com.waycourier.app.repository.IDeliveryRecordRepository;
import com.waycourier.app.repository.IPackageIndexRepository;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.repository.IUserRepository;
import com.waycourier.app.to.PackageRequestTO;
import com.waycourier.app.utility.CustomIdGenerator;
import com.waycourier.app.utility.GeoUtil;

@Service
public class PackageService {
	@Autowired
	IPackageRepository packageRepository;

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IDeliveryRecordRepository deliveryRecordRepository;

	@Autowired
	IPackageIndexRepository packageEntityRepository;
	
	@Autowired
	CustomIdGenerator customIdGenerator;

	public void acceptPackageForDelivery(String username, int packageId) {
		User user = userRepository.findByUsername(username);
		DeliveryRecord deliveryRecord = new DeliveryRecord();
		deliveryRecord.setUserId(user.getId());
		deliveryRecord.setPackageId(packageId);
		deliveryRecord.setStatus(PackageStatus.ACCEPTED);

		// TODO: update package details in PackageEntity 
	}
	
	//Main service to create a new Package entity and its corresponding Geohash entity
	public Package createPackage(PackageRequestTO packageRequestTO) {
		Package p = new Package();

		try {
			p.setName(packageRequestTO.packageName());
			p.setLatitude(packageRequestTO.location().lat());
			p.setLongitude(packageRequestTO.location().lng());
			p.setAddress(packageRequestTO.deliveryAddress());
			// p.setId(customIdGenerator.generatePackageId());
			p.setRecEndDate(new Date(253402300799000L));
			p.setCreatedAt(new Date());
			p.setStatus(PackageStatus.CREATED);
			p.setFragile((packageRequestTO.fragile() != null && packageRequestTO.fragile()) ? true : false);
			p.setUsername(packageRequestTO.username());
			// p.setRecptMobNo(packageRequestTO.recptMobNo());
			
			p = packageRepository.save(p);

			String geohash = GeoUtil.getGeoHash(packageRequestTO.location());

			PackageIndex pi = new PackageIndex(p, geohash);
			packageEntityRepository.save(pi);
			
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return p;
	}
	
	//Main service packages with their packageId
	public Package findPackageById(int id) {

		Optional<Package> p = packageRepository.findById(id);

		if (p.isPresent()) {
			return p.get();
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No package found with ID - " + id);
		}
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

		try {
			Package p = updatedPkg.get();

			if(pkg.status() != null)
				p.setStatus(pkg.status());
			
			if(pkg.fragile() != null)
				p.setFragile(pkg.fragile());
			
			//TODO: Any other updating feature can be updated later
			
			return packageRepository.save(p);

		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
