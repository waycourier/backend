package com.waycourier.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.repository.PackageEntityRepository;
import com.waycourier.app.to.Location;
import com.waycourier.app.utility.GeoUtil;

@Service
public class LocationService {
    private final int DEFAULT_LOC_PRECISION = 6;

    @Autowired
    private PackageEntityRepository packageEntityRepository;

    public List<PackageEntity> getNearbyPackageIndexes(Location location) {
        String geohash = GeoUtil.getGeoHash(location, DEFAULT_LOC_PRECISION);

        return packageEntityRepository
            .findByGeoHashLike(geohash.substring(0, 6));
    }
}
