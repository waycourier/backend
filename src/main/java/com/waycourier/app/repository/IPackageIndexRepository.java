package com.waycourier.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.PackageIndex;

@Repository
public interface IPackageIndexRepository extends JpaRepository<PackageIndex, Integer> {

    List<PackageIndex> findBySrcGeoHashLike(String geoHash);
    
    List<PackageIndex> findByDestGeoHashLike(String geoHash);
}
