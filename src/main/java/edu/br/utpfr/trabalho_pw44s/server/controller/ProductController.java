package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.ProductResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("product")
public class ProductController extends CrudController<Product, ProductRequestDto, ProductResponseDto, Long>{

    private final IProductService service;
    private final ModelMapper mapper;

    public ProductController(IProductService service, ModelMapper mapper){
        super(Product.class, ProductResponseDto.class, ProductRequestDto.class);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@RequestBody @Valid ProductRequestDto request, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(request), ProductResponseDto.class));
    }

    @GetMapping("find")
    public ResponseEntity<List<Product>> findAll(@RequestParam(value = "isTop", required = false) Boolean top) {
        List<Product> topProducts = service.getProducts(top);
        return ResponseEntity.ok(topProducts);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable Long id) {
        List<Product> topProducts = service.getProductsByCategory(id);
        return ResponseEntity.ok(topProducts);
    }

    @Override
    protected ICrudService<Product, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
