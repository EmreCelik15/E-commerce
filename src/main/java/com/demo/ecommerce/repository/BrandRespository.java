package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRespository extends JpaRepository<Brand,Long> {
}
