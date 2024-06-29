package com.waycourier.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waycourier.app.models.DeliveryRecord;

@Repository
public interface IDeliveryRepository extends CrudRepository<DeliveryRecord, Integer> {

}
