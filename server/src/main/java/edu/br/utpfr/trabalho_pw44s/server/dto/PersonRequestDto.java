package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDto {

    @NotBlank
    private String name;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;
    @Pattern(regexp = "^(\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x)$")
    private String rg;
    @Pattern(regexp = "^\\d{3}.?\\d{3}.?\\d{3}.?\\d{3}$")
    private String ie;
    @NotBlank
    @Pattern(regexp = "(?:(?:(\\+|00)?(55))\\s?)?(?:\\(?(\\d{2})\\)?\\s?)(|\\d{2})(|-)?(?:(9\\d|[2-9])\\d{3}[-|.|\\s]?(\\d{4}))")
    private String phone;
//    @NotNull
//    private long user;
}
