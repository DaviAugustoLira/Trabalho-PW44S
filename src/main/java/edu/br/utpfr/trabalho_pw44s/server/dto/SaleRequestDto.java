package edu.br.utpfr.trabalho_pw44s.server.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class SaleRequestDto {

//    @NotNull
//    private Long buyer;
    @NotNull
    private Long address;
    @NotNull
    @Min(1)
    private BigDecimal total_value;
    @NotNull
    private List<ProductSaleRequestDto> products;
}
