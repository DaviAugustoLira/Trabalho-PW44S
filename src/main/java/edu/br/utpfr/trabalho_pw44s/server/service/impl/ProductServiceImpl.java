package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.repository.PersonRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.ProductRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements IProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;
    private final CategoryServiceImpl categoryService;

    public Product save(ProductRequestDto requestDto) {
        Product product = mapper.map(requestDto, Product.class);
        product.setCategory(categoryService.findById(requestDto.getCategory()));

        return this.repository.save(product);
    }

    public List<Product> getProducts(Boolean isTop) {
        if(isTop == null){
            return repository.findAll();
        }
        return repository.findByTop(isTop);
    }

    @Override
    public List<Product> getProductsByCategory(Long id) {
        return repository.findByCategory_Id(id);
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Product> iterable) {

    }
}
