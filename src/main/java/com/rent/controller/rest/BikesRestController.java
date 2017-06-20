package com.rent.controller.rest;

import com.rent.dto.BikeDto;
import com.rent.mapper.dto.BikeDtoMapper;
import com.rent.persistence.model.Bike;
import com.rent.service.bike.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotocan on 18.6.2017..
 */

@RestController
public class BikesRestController {

    @Autowired
    BikeService bikeService;

    @Autowired
    BikeDtoMapper bikeDtoMapper;

    @GetMapping("/api/bikes")
    @ResponseStatus(HttpStatus.OK)
    public List<BikeDto> getAllBikes() {

        List<BikeDto> bikeDtos = new ArrayList<>();
        List<Bike> bikes = bikeService.listAllBikes();

        for (Bike bike : bikes) {
            bikeDtos.add(bikeDtoMapper.mapToDto(bike));
        }

        return bikeDtos;
    }
}
