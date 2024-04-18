package com.waycourier.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.waycourier.app.models.Package;
import com.waycourier.app.service.PackageService;
import com.waycourier.app.to.ErrorMessage;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
	@Autowired
	PackageService pkgService;

	// "POST - /api/package/ -> creates a new Package entity
	@PostMapping("/")
	ResponseEntity<?> addPackage(@RequestBody Package inpPkg) {
		Package createdPkg = pkgService.createPackage(inpPkg);

		return ResponseEntity.ok(createdPkg);

	}

	// "GET - /api/packages/Pk001 -> finds package having mentioned packageId
	@GetMapping("/{pkgId}")
	ResponseEntity<?> getPackageById(@PathVariable String pkgId) {
			return ResponseEntity.ok(pkgService.findPackagesById(pkgId));
	}

	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<ErrorMessage> handleStatusCodeException(HttpStatusCodeException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getStatusCode().value(), e.getStatusText(), e.getMessage());
		return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error",
				e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}
}
