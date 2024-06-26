package com.waycourier.app.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.PackageIndex;
import com.waycourier.app.service.LocationService;
import com.waycourier.app.service.PackageService;
import com.waycourier.app.to.PackageIndexResponseTO;
import com.waycourier.app.models.Location;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private PackageService packageService;

    @GetMapping("/search")
    public ResponseEntity<?> getNearbyPackages(
    		@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        Location loc = new Location(lat, lng);
        List<PackageIndexResponseTO> nearbyPackageIndexes = locationService.getNearbyPackageIndexes(loc);

        return ResponseEntity.ok(nearbyPackageIndexes);
    }

	@PostMapping("/deliver/{packageId}")
	public ResponseEntity<?> deliveryPackage(Principal principal, @PathVariable int packageId) {

		String username = principal.getName();
		boolean accepted = packageService.acceptPackageForDelivery(username, packageId);
		
		if(accepted) {
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.badRequest().body("error occured");
	}
}
