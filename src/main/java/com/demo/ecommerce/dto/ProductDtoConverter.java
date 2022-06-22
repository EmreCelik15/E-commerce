package com.demo.ecommerce.dto;

import com.demo.ecommerce.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {
    private final CategoryDtoConverter categoryDtoConverter;
    private final MarketDtoConverter marketDtoConverter;
    private final ShopDtoConverter shopDtoConverter;

    public ProductDtoConverter(CategoryDtoConverter categoryDtoConverter, MarketDtoConverter marketDtoConverter, ShopDtoConverter shopDtoConverter) {
        this.categoryDtoConverter = categoryDtoConverter;
        this.marketDtoConverter = marketDtoConverter;
        this.shopDtoConverter = shopDtoConverter;
    }

    public ProductDto convertDto(Product from) {
        return new ProductDto(from.getId(), from.getProductName(), from.getPrice(),
                categoryDtoConverter.convertDto(from.getCategory()),
                marketDtoConverter.convertDto(from.getMarket()),
                shopDtoConverter.convertDto(from.getShop()));
    }

    public Product toEntity(ProductDto from, MarketDto marketDto) {
        return new Product(from.getId(), from.getProductName(), from.getPrice(),
                categoryDtoConverter.toEntity(from.getCategory()),
                marketDtoConverter.toEntity(from.getMarket()),
                shopDtoConverter.toEntity(from.getShop()));
    }
}
