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
public class ProductSaleResponseDto {

    private ProductResponseDto product;
    private float quantity;
    private BigDecimal price;
}
