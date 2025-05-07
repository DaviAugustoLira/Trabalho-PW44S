package edu.br.utpfr.trabalho_pw44s.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {

    private String sku;
    private String name;
    private String description;
    private BigDecimal retail_value;
    private BigDecimal wholesale_value;
    private float wholesale_min_quantity;
    private float stock;
    private boolean free_freight;
    private boolean isActive;
    private Long category;
}
