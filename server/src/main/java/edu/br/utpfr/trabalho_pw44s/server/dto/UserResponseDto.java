package edu.br.utpfr.trabalho_pw44s.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String Username;
    private String password;
    private String email;
}
