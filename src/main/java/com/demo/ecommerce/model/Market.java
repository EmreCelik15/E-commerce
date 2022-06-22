package com.demo.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "markets")
public class Market {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String marketName;

    @Column(name = "adress")
    @NotNull(message = "Adress can not be null!")
    private String adress;

    @Column(name = "shops_count")
    @NotNull(message = "Shop count can not be null!")
    private Long shopCount;
}
