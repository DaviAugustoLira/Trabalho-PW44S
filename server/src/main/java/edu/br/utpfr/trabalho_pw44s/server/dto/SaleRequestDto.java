package edu.br.utpfr.trabalho_pw44s.server.dto;

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

    private Long buyer;
    private Long address;
    private BigDecimal total_value;
    private List<ProductSaleRequestDto> products;
}
