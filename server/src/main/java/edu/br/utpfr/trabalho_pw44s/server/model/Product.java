package edu.br.utpfr.trabalho_pw44s.server.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Min(1)
    private BigDecimal retail_value;

    @NotNull
    @Min(1)
    private BigDecimal wholesale_value;

    @NotNull
    @Min(1)
    private float wholesale_min_quantity;

    @NotNull
    @Min(1)
    private float stock;

    @NotNull
    private boolean free_freight;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "product_category")
    private Category category;

}
