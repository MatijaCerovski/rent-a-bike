package com.rent.service.bike;

import com.rent.persistence.model.Bike;

public interface BikeService {

    Bike findById(Integer bikeId);

    Bike save(Bike bike);
}
