package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketDto {
    private Long id;
    private String marketName;
    private String adress;
    private Long shopCount;
}
