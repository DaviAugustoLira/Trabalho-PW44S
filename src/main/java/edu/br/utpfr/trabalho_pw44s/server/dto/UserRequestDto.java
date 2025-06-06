package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class UserRequestDto {
    @NotNull
    @Size(min = 4, max = 50)
    private String username;
    @NotNull
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
    @NotNull
    @Email
    private String email;
}
