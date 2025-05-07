package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.service.IAddressService;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("address")
public class AddressController extends CrudController<Address, AddressRequestDto, AddressResponseDto, Long>{

    private static IAddressService service;
    private static ModelMapper mapper;

    public AddressController(IAddressService service, ModelMapper mapper){
        super(Address.class, AddressResponseDto.class, AddressRequestDto.class);
        AddressController.service = service;
        AddressController.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AddressResponseDto> save(@RequestBody @Valid AddressRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(request), AddressResponseDto.class));
    }


    @Override
    protected ICrudService<Address, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}














