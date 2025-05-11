package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import edu.br.utpfr.trabalho_pw44s.server.repository.ProductRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.SaleRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductSaleService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import edu.br.utpfr.trabalho_pw44s.server.service.ISaleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class SaleServiceImpl extends CrudServiceImpl<Sale, Long> implements ISaleService {

    private final SaleRepository repository;
    private final ModelMapper mapper;
    private final AddressServiceImpl addressService;
    private final UserRepository userRepository;
    private final ProductServiceImpl productService;
    private final ProductSaleServiceImpl productSaleService;

    public Sale save(SaleRequestDto requestDto) {
        Sale sale = mapper.map(requestDto, Sale.class);
        sale.setAddress(addressService.findById(requestDto.getAddress()));
        sale.setBuyer(userRepository.findById(requestDto.getBuyer()).orElseThrow(() -> new EntityNotFoundException("User Not Found")));

        List<Product_Sale> products = requestDto.getProducts().stream().map(product -> {
            Product_Sale productSale = mapper.map(product, Product_Sale.class);
            productSale.setSale(sale);
            productSale.setProduct(productService.findById(product.getProduct()));
            return productSale;
        }).collect(Collectors.toList());

        sale.setProducts(products);

        repository.save(sale);
        return this.repository.save(sale);
    }

    @Override
    public List<Sale> findByBuyerId(Long id) {
        return repository.findByBuyerId(id);
    }

    @Override
    protected JpaRepository<Sale, Long> getRepository() {
        return this.repository;
    }


    @Override
    public void delete(Iterable<? extends Sale> iterable) {

    }
}
