package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.ProductResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IProductService;
import edu.br.utpfr.trabalho_pw44s.server.service.ISaleService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sale")
public class SaleController extends CrudController<Sale, SaleRequestDto, SaleResponseDto, Long>{

    private static ISaleService service;
    private static ModelMapper mapper;

    public SaleController(ISaleService service, ModelMapper mapper){
        super(Sale.class, SaleResponseDto.class, SaleRequestDto.class);
        SaleController.service = service;
        SaleController.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDto> save(@RequestBody @Valid SaleRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(request), SaleResponseDto.class));
    }

    @GetMapping("buyer/{id}")
    public ResponseEntity<List<SaleResponseDto>> save(@PathVariable Long id){
        List<SaleResponseDto> dtoList = service.findByBuyerId(id)
                .stream()
                .map(sale -> mapper.map(sale, SaleResponseDto.class))
                .toList();
        return ResponseEntity.ok(dtoList);
    }


    @Override
    protected ICrudService<Sale, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
