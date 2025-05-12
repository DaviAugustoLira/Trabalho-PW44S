package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.*;
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

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("sale")
public class SaleController extends CrudController<Sale, SaleRequestDto, SaleResponseDto, Long>{

    private final ISaleService service;
    private final ModelMapper mapper;

    public SaleController(ISaleService service, ModelMapper mapper){
        super(Sale.class, SaleResponseDto.class, SaleRequestDto.class);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<SaleResponseDto> save(@RequestBody @Valid SaleRequestDto request, Principal principal){
        SaleResponseDto responseDto = service.create(request, principal);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("buyer")
    public ResponseEntity<List<SaleResponseDto>> save(Principal principal){
        List<SaleResponseDto> dtoList = service.findByBuyer(principal)
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
