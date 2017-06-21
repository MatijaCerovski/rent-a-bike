package com.rent.mapper.dto;

import com.rent.dto.BikeDto;
import com.rent.persistence.model.Bike;
import com.rent.persistence.model.Shop;
import com.rent.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dotocan on 18.6.2017..
 */

@Component
public class BikeDtoMapper {

    @Autowired
    ShopService shopService;

    public BikeDto mapToDto(Bike bike) {
        BikeDto bikeDto = new BikeDto();
        bikeDto.setBikeId(bike.getBikeId());
        bikeDto.setModel(bike.getModel());
        bikeDto.setMaker(bike.getMaker());
        bikeDto.setPrice(bike.getPrice());

        return bikeDto;
    }

    public Bike mapToEntity(BikeDto bikeDto) {
        Bike bike = new Bike();

        bike.setMaker(bikeDto.getMaker());
        bike.setModel(bikeDto.getModel());
        bike.setPrice(bikeDto.getPrice());

        Shop shop = shopService.findById((long) 1);
        bike.setShop(shop);

        return bike;
    }
}
