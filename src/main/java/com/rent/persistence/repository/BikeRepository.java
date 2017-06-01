package com.rent.persistence.repository;

import com.rent.persistence.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Integer> {

}
