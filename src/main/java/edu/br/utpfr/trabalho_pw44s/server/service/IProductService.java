package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;

public interface IProductService extends ICrudService<Product, Long>{
    Product save(ProductRequestDto requestDto);
}
