package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
