package com.waycourier.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.Package;
import com.waycourier.app.service.PackageService;
import com.waycourier.app.to.PackageRequestTO;
import com.waycourier.app.utility.RequestResponseHandler;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
	
	@Autowired
	PackageService packageService;

	// "POST - /api/packages/ -> creates a new Package entity
	@PostMapping("/")
	ResponseEntity<?> addPackage(@RequestBody PackageRequestTO packageDataTO) {
		Package createdPkg = packageService.createPackage(packageDataTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(createdPkg);

	}

	// "GET - /api/packages/Pk001 -> finds package having mentioned packageId
	@GetMapping("/{pkgId}")
	ResponseEntity<?> getPackageById(@PathVariable String pkgId) {
			return ResponseEntity.ok(RequestResponseHandler.getPackageRespTO(packageService.findPackagesById(pkgId)));
	}
	
	@PostMapping("/update")
	ResponseEntity<?> updatePackage(@RequestBody PackageRequestTO pkg){
		return ResponseEntity.ok(packageService.updatePkgDetails(pkg));
	}

}
