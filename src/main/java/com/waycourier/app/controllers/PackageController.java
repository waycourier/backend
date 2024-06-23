package com.waycourier.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.Package;
import com.waycourier.app.service.PackageService;
import com.waycourier.app.to.PackageRequestTO;
import com.waycourier.app.to.PackageResponseTO;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
	
	@Autowired
	PackageService packageService;

	@PostMapping
	ResponseEntity<?> addPackage(@RequestBody PackageRequestTO packageDataTO) {
		return packageService.createPackage(packageDataTO);
	}

	@GetMapping("/{pkgId}")
	ResponseEntity<?> getPackageById(@PathVariable int pkgId) {
		return packageService.findPackageById(pkgId);
	}
	
	@PutMapping
	ResponseEntity<?> updatePackage(@RequestBody PackageRequestTO pkg){
		Package p = packageService.updatePackage(pkg);
		return ResponseEntity.ok(new PackageResponseTO(p));
	}

}
