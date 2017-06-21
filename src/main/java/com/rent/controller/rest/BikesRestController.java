package com.rent.controller.rest;

import com.rent.dto.BikeDto;
import com.rent.mapper.dto.BikeDtoMapper;
import com.rent.persistence.model.Bike;
import com.rent.service.bike.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotocan on 18.6.2017..
 */

@RestController
@RequestMapping("/api/bikes")
public class BikesRestController {

    @Autowired
    BikeService bikeService;

    @Autowired
    BikeDtoMapper bikeDtoMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BikeDto> getAllBikes() {

        List<BikeDto> bikeDtos = new ArrayList<>();
        List<Bike> bikes = bikeService.listAllBikes();

        for (Bike bike : bikes) {
            bikeDtos.add(bikeDtoMapper.mapToDto(bike));
        }

        return bikeDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBike(BikeDto bikeDto) {

        Bike bike = bikeDtoMapper.mapToEntity(bikeDto);
        bikeService.save(bike);
    }

    @PutMapping
    public void updateBike(BikeDto bikeDto) {
        Bike bike = bikeService.findById(bikeDto.getBikeId());
        bike.setMaker(bikeDto.getMaker());
        bike.setModel(bikeDto.getModel());
        bike.setPrice(bikeDto.getPrice());
        bikeService.save(bike);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id)
    {
        bikeService.delete(bikeService.findById(id));
    }

}
