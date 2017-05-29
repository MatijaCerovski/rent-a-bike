package com.rent.service.shop;

import com.rent.persistence.model.Shop;

import java.util.List;

public interface ShopService {

    Shop findById(Long id);

    Shop save(Shop shop);

    List<Shop> findAllByName(String name);
}
