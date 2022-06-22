package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopDtoConverter {

    private final MarketDtoConverter marketDtoConverter;

    public ShopDtoConverter(MarketDtoConverter marketDtoConverter) {
        this.marketDtoConverter = marketDtoConverter;
    }

    public ShopDto convertDto(Shop from){
        return new ShopDto(from.getId(), from.getShopName(), from.getAdress(),
                marketDtoConverter.convertDto(from.getMarket()));
    }
    public Shop toEntity(ShopDto from){
        return new Shop(from.getId(), from.getShopName(),from.getShopName(),from.getProductCount(),
                marketDtoConverter.toEntity(from.getMarket()));
    }
}
