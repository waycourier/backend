package com.waycourier.app.utility;

import com.waycourier.app.to.Location;

import ch.hsr.geohash.GeoHash;

public class GeoUtil {
    public static String getGeoHash(Location location, int precision) {
        return GeoHash.geoHashStringWithCharacterPrecision(
            location.lat(), 
            location.lng(), 
            7);
    }

    public static String getGeoHash(Location location) {
        return getGeoHash(location, 7);
    }
}
