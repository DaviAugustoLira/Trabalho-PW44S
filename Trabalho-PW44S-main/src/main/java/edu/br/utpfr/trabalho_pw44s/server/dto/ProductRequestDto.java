package edu.br.utpfr.trabalho_pw44s.server.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

public class ProductRequestDto {

    @NotBlank
    private String sku;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    @Min(1)
    private BigDecimal retail_value;
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal wholesale_value;
    @NotNull
    @Min(1)
    private float wholesale_min_quantity;
    @NotNull
    @DecimalMin("0.1")
    private float stock;
    @NotNull
    private boolean free_freight;
    @NotNull
    private boolean isActive;
    @NotNull
    private Long category;
    private String urlImage;
}
