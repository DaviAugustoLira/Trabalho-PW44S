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

import java.security.Principal;


//@RequiredArgsConstructor

@RestController
@RequestMapping("address")
public class AddressController extends CrudController<Address, AddressRequestDto, AddressResponseDto, Long>{

    private final IAddressService service;
    private final ModelMapper mapper;

    public AddressController(IAddressService service, ModelMapper mapper){
        super(Address.class, AddressResponseDto.class, AddressRequestDto.class);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<AddressResponseDto> save(@RequestBody @Valid AddressRequestDto request, Principal principal){
        AddressResponseDto responseDto = service.create(request, principal);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
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














