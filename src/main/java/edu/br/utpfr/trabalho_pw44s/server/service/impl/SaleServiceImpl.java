package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
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

import java.security.Principal;
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

    @Override
    public SaleResponseDto create(SaleRequestDto request, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        if(user == null) throw new EntityNotFoundException("User Not Found!");

        Sale sale = mapper.map(request, Sale.class);
        sale.setBuyer(user);
        sale.setAddress(addressService.findById(request.getAddress()));

        List<Product_Sale> products = request.getProducts().stream().map(product -> {
            Product_Sale productSale = mapper.map(product, Product_Sale.class);
            productSale.setSale(sale);
            productSale.setProduct(productService.findById(product.getProduct()));
            return productSale;
        }).collect(Collectors.toList());

        sale.setProducts(products);
        return mapper.map(save(sale), SaleResponseDto.class);
    }

    @Override
    public List<Sale> findByBuyer(Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        return repository.findByBuyerId(user.getId());
    }



    @Override
    protected JpaRepository<Sale, Long> getRepository() {
        return this.repository;
    }


    @Override
    public void delete(Iterable<? extends Sale> iterable) {

    }
}
