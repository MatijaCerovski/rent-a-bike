package com.rent.persistence.repository;

import com.rent.persistence.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

   List<Shop> findAllByName(String name);

}
