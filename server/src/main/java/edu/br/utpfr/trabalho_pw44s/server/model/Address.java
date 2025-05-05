package edu.br.utpfr.trabalho_pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @Min(1)
    private int number;

    @Pattern(regexp = "(^\\d{5})\\-?(\\d{3}$)")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "address_person")
    private Person person;
}

