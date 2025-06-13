package edu.br.utpfr.trabalho_pw44s.server.dto;

import edu.br.utpfr.trabalho_pw44s.server.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private Long id;
    private String name;
    private boolean top;
}
