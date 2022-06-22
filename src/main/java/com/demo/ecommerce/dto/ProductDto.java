package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.model.Market;
import com.demo.ecommerce.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Integer price;
    private CategoryDto category;
    private MarketDto market;
    private ShopDto shop;

    public ProductDto(Long id, String productName, Integer price, Long id1, Long id2, Long id3) {
    }
}
