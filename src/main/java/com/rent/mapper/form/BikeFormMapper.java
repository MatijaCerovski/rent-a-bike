package com.rent.mapper.form;

import com.rent.form.BikeForm;
import com.rent.persistence.model.Bike;
import com.rent.persistence.model.Shop;
import com.rent.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dotocan on 7.6.2017..
 */

@Component
public class BikeFormMapper {

    @Autowired
    ShopService shopService;

    public Bike mapToEntity(BikeForm bikeForm) {
        Bike bike = new Bike();

        bike.setMaker(bikeForm.getMaker());
        bike.setModel(bikeForm.getModel());
        bike.setPrice(bikeForm.getPrice());

        Shop shop = shopService.findById((long) 1);
        bike.setShop(shop);

        return bike;
    }
}
