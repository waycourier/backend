package com.waycourier.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.PackageIndex;


public interface IPackageIndexRepository extends JpaRepository<PackageIndex, Integer> {

    List<PackageIndex> findByGeoHashLike(String geoHash);
    
}
