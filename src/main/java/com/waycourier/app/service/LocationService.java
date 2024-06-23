package com.waycourier.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.waycourier.app.models.PackageIndex;
import com.waycourier.app.repository.IPackageIndexRepository;
import com.waycourier.app.to.PackageIndexResponseTO;
import com.waycourier.app.to.PackageResponseTO;
import com.waycourier.app.models.Location;
import com.waycourier.app.utility.GeoUtil;

@Service
public class LocationService {

    private final int DEFAULT_LOC_PRECISION = 6;
    private final IPackageIndexRepository packageIndexRepository;

    public LocationService(IPackageIndexRepository packageIndexRepository) {
        this.packageIndexRepository = packageIndexRepository;
    }

    public List<PackageIndexResponseTO> getNearbyPackageIndexes(Location location) {

        String geohash = GeoUtil.getGeoHash(location, DEFAULT_LOC_PRECISION);
        List<PackageIndex> nearbyPackages = packageIndexRepository.findBySrcGeoHashLike(
        		geohash.substring(0, 6) + "%");

        // TODO: need to convert this to pagination
        List<PackageIndexResponseTO> list = nearbyPackages.stream()
        		.map(PackageIndexResponseTO::new)
        		.limit(10)
        		.toList();

        return list;
    }
}
