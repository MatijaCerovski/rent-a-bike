package com.rent.service.shop;

import com.rent.persistence.model.Shop;
import com.rent.persistence.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop findById(Long id) {
        if (id == null) {
            return null;
        }
        return shopRepository.findOne(id);
    }

    @Override
    public Shop save(Shop shop) {
        if (shop == null) {
            return null;
        }
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> findAllByName(String name) {
        if (name == null) {
            return null;
        }
        return shopRepository.findAllByName(name);
    }
}
