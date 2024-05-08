package com.waycourier.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.waycourier.app.models.PackageEntity;

public interface PackageEntityRepository extends MongoRepository<PackageEntity, String> {
    List<PackageEntity> findByGeoHashLike(String geohash);
}
