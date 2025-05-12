package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.security.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {
    private long id;
    private String city;
    private String street;
    private int number;
    private String cep;
    private UserResponseDTO user;
}
