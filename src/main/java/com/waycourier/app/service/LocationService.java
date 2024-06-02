package com.waycourier.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waycourier.app.models.PackageIndex;
import com.waycourier.app.repository.IPackageIndexRepository;
import com.waycourier.app.to.Location;
import com.waycourier.app.utility.GeoUtil;

@Service
public class LocationService {

    private final int DEFAULT_LOC_PRECISION = 6;
    private final IPackageIndexRepository packageIndexRepository;

    @Autowired
    public LocationService(IPackageIndexRepository packageIndexRepository) {
        this.packageIndexRepository = packageIndexRepository;
    }

    public List<PackageIndex> getNearbyPackageIndexes(Location location) {

        String geohash = GeoUtil.getGeoHash(location, DEFAULT_LOC_PRECISION);
        List<PackageIndex> nearbyPackages = packageIndexRepository.findByGeoHashLike(geohash.substring(0, 6)+"_");

        // TODO: need to convert this to pagination
        nearbyPackages = nearbyPackages.stream().limit(10).toList();

        return nearbyPackages;
    }
}
