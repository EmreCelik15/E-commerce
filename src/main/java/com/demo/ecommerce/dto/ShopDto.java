package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Market;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private Long id;
    private String shopName;
    private String adress;
    private Long productCount;
    private MarketDto market;

    public ShopDto(Long id, String shopName, String adress, MarketDto convertDto) {
    }
}
