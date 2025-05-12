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


    private String sku;
    private String name;
    private String description;
    private BigDecimal retail_value;
    private BigDecimal wholesale_value;
    private float wholesale_min_quantity;
    private float stock;
    private boolean free_freight;
    private boolean isActive;
    private String urlImage;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category")
    private Category category;
}
