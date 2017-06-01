package com.rent.service.bike;

import com.rent.persistence.model.Bike;

public interface BikeService {

    Bike findById(Integer id);

    Bike save(Bike bike);
}
