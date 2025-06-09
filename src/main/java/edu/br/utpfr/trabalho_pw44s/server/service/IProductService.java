package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService extends ICrudService<Product, Long>{
    Product save(ProductRequestDto requestDto);
    List<Product> getProducts(Boolean isTop);
    List<Product> getProductsByCategory(Long id);
}
