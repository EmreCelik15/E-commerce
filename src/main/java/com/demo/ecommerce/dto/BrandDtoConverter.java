package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class BrandDtoConverter {
    public BrandDto convertDto(Brand from) {
        return new BrandDto(from.getId(), from.getBrandName());
    }

    public Brand toEntity(BrandDto from) {
        return new Brand(from.getId(), from.getBrandName());
    }

    public List<BrandDto> convertToBrandDToList(List<Brand> brands) {
        List<BrandDto> brandDtos = new ArrayList<>();
        brands.forEach(brand -> brandDtos.add(convertDto(brand)));
        return brandDtos;
    }
}
