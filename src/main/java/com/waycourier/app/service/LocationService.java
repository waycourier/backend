package com.waycourier.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waycourier.app.models.Package;
import com.waycourier.app.models.PackageEntity;
import com.waycourier.app.repository.IPackageRepository;
import com.waycourier.app.repository.PackageEntityRepository;
import com.waycourier.app.to.Location;
import com.waycourier.app.utility.GeoUtil;

@Service
public class LocationService {
    private final int DEFAULT_LOC_PRECISION = 6;

    @Autowired
    private PackageEntityRepository packageEntityRepository;

    @Autowired
    private IPackageRepository packageRepository;

    public List<PackageEntity> getNearbyPackageIndexes(Location location) {
        String geohash = GeoUtil.getGeoHash(location, DEFAULT_LOC_PRECISION);

        List<PackageEntity> nearbyPackages = packageEntityRepository
            .findByGeoHashLike(geohash.substring(0, 6));

        nearbyPackages = nearbyPackages.stream().limit(10).toList();

        for(PackageEntity pkg : nearbyPackages) {
            Optional<Package> byPackageId = packageRepository.findByPackageId(pkg.getPackageId());
            if(byPackageId.isPresent()) {
                Package p = byPackageId.get();
                pkg.setLocation(new Location(p.getPkgLatitude(), p.getPkgLongitude()));
            }
        }

        return nearbyPackages;
    }
}
