package com.rent.service.bike;

import com.rent.persistence.model.Bike;

import java.util.List;

public interface BikeService {

    Bike findById(Integer bikeId);

    List<Bike> listAllBikes();

    Bike save(Bike bike);


}
