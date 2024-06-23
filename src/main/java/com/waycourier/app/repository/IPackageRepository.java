package com.waycourier.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.Package;

@Repository
public interface IPackageRepository extends CrudRepository<Package, Integer> {

    Optional<Package> findPackageById(int id);
    
}
