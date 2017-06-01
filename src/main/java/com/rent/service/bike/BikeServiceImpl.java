package com.rent.service.bike;

import com.rent.persistence.model.Bike;
import com.rent.persistence.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike findById(Integer bikeId) {
        if (bikeId == null) {
            return null;
        }
        return bikeRepository.findOne(bikeId);
    }

    @Override
    public Bike save(Bike bike) {
        if (bike == null) {
            return null;
        }
        return bikeRepository.save(bike);
    }

}
