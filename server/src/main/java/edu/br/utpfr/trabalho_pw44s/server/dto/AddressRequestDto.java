package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    private int number;
    @Pattern(regexp = "(^\\d{5})\\-?(\\d{3}$)")
    private String cep;
    @NotNull
    private Long user;
}