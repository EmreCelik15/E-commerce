package com.demo.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "markets")
public class Shop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Shopname can not be null!")
    private String shopName;

    @Column(name = "adress")
    @NotNull(message = "Adress can not be null!")
    private String adress;

    @Column(name="products_count")
    @NotNull(message = "Count can not be null!")
    private Long productCount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "market_id",nullable = false)
    private Market market;

}
