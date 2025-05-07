package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import edu.br.utpfr.trabalho_pw44s.server.repository.ProductRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.SaleRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductSaleService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import edu.br.utpfr.trabalho_pw44s.server.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class SaleServiceImpl extends CrudServiceImpl<Sale, Long> implements ISaleService {

    private final SaleRepository repository;
    private final ModelMapper mapper;
    private final AddressServiceImpl addressService;
    private final PersonServiceImpl personService;
    private final ProductServiceImpl productService;
    private final ProductSaleServiceImpl productSaleService;

    public Sale save(SaleRequestDto requestDto) {
        Sale sale = mapper.map(requestDto, Sale.class);
        sale.setAddress(addressService.findById(requestDto.getAddress()));
        sale.setBuyer(personService.findById(requestDto.getBuyer()));

        List<Product_Sale> products = new ArrayList<>();
        requestDto.getProducts().forEach( product -> {
            Product_Sale productSale = new Product_Sale();
            productSale.setProduct(productService.findById(product.getProduct()));
            productSale.setQuantity(product.getQuantity());
            productSale.setPrice(product.getPrice());
            products.add(productSale);
        });

        sale.setProducts(productSaleService.save(products));

        repository.save(sale);
        return this.repository.save(sale);
    }

    @Override
    public List<Sale> findByBuiyerId(Long id) {
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
