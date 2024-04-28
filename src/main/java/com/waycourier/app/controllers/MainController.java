package com.waycourier.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.service.LocationService;
import com.waycourier.app.to.Location;

@RestController
@RequestMapping("/api/search")
public class MainController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getNearbyPackages(@RequestBody Location loc) {
        List<PackageEntity> nearbyPackageIndexes = locationService.getNearbyPackageIndexes(loc);

        return ResponseEntity.ok(nearbyPackageIndexes);
    }
}
