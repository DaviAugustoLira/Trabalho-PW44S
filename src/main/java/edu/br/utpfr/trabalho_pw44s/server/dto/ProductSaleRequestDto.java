package edu.br.utpfr.trabalho_pw44s.server.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class ProductSaleRequestDto {

    @NotNull
    private long product;
    @NotNull
    @Min(1)
    private float quantity;
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal price;
}
