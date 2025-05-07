package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import edu.br.utpfr.trabalho_pw44s.server.repository.ProductRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.ProductSaleRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductSaleService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class ProductSaleServiceImpl extends CrudServiceImpl<Product_Sale, Long> implements IProductSaleService {

    private final ProductSaleRepository repository;
    private final ModelMapper mapper;
    private final CategoryServiceImpl categoryService;

    @Override
    protected JpaRepository<Product_Sale, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Product_Sale> iterable) {

    }
}
