package com.waycourier.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.service.LocationService;
import com.waycourier.app.to.Location;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/search")
    public ResponseEntity<?> getNearbyPackages(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        Location loc = new Location(lat, lng);
        List<PackageEntity> nearbyPackageIndexes = locationService.getNearbyPackageIndexes(loc);

        return ResponseEntity.ok(nearbyPackageIndexes);
    }
}
