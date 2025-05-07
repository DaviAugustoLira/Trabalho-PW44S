package edu.br.utpfr.trabalho_pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "tb_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Min(4) @Max(25)
    private String Username;

    @NotBlank
    @Min(6) @Max(20)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

    @NotBlank
    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "person_user")
    private Person person;
}
