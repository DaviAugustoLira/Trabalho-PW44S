package edu.br.utpfr.trabalho_pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Min(4) @Max(25)
    private String Username;

    @NotBlank
    @Min(8) @Max(20)
    private String password;

    @NotBlank
    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "fk_person_user")
    private Person person;
}
