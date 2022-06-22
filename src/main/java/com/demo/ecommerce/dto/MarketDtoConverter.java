package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Market;
import org.springframework.stereotype.Component;

@Component
public class MarketDtoConverter {
    public MarketDto convertDto(Market from) {
        return new MarketDto(from.getId(), from.getMarketName(), from.getAdress(), from.getShopCount());

    }

    public Market toEntity(MarketDto from) {
        return new Market(from.getId(), from.getMarketName(), from.getAdress(), from.getShopCount());
    }
}
