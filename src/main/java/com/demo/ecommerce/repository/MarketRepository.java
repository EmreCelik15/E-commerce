package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market,Long> {
}
