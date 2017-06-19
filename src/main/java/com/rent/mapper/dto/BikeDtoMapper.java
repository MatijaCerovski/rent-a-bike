package com.rent.mapper.dto;

import com.rent.dto.BikeDto;
import com.rent.persistence.model.Bike;
import org.springframework.stereotype.Component;

/**
 * Created by dotocan on 18.6.2017..
 */

@Component
public class BikeDtoMapper {

    public BikeDto mapToDto(Bike bike) {
        BikeDto bikeDto = new BikeDto();
        bikeDto.setBikeId(bike.getBikeId());
        bikeDto.setModel(bike.getModel());
        bikeDto.setMaker(bike.getMaker());
        bikeDto.setPrice(bike.getPrice());

        return bikeDto;
    }
}
