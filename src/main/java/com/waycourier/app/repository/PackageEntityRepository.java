package com.waycourier.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.PackageEntity;

@Repository
public interface PackageEntityRepository extends MongoRepository<PackageEntity, Integer> {
    List<PackageEntity> findByGeoHashLike(String geohash);
}
