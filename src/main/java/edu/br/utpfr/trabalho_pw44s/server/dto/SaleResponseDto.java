package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import edu.br.utpfr.trabalho_pw44s.server.security.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDto {

    private Long id;
    private UserResponseDTO buyer;
    private AddressResponseDto address;
    private BigDecimal total_value;
    private LocalDateTime data;
    private List<ProductSaleResponseDto> products;
}
