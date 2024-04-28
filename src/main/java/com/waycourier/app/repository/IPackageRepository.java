package com.waycourier.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.Package;

@Repository
public interface IPackageRepository extends MongoRepository<Package, String> {
    Optional<Package> findByPackageId(String id);
}
