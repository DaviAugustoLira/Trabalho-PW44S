package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("person")
public class PersonController extends CrudController<Person, PersonRequestDto, PersonResponseDto, Long>{

    private final IPersonService service;
    private final ModelMapper mapper;

    public PersonController(IPersonService service, ModelMapper mapper){
        super(Person.class, PersonResponseDto.class, PersonRequestDto.class);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<PersonResponseDto> save(@RequestBody @Valid PersonRequestDto request, Principal principal){
        PersonResponseDto responseDto = service.create(request, principal);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Override
    protected ICrudService<Person, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
