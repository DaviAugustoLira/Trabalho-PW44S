package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.ProductRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.ProductResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("person")
public class PersonController extends CrudController<Person, PersonRequestDto, PersonResponseDto, Long>{

    private static IPersonService service;
    private static ModelMapper mapper;

    public PersonController(IPersonService service, ModelMapper mapper){
        super(Person.class, PersonResponseDto.class, PersonRequestDto.class);
        PersonController.service = service;
        PersonController.mapper = mapper;
    }

//    @PostMapping
//    public ResponseEntity<PersonResponseDto> save(@RequestBody @Valid PersonRequestDto request){
//        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(mapper.map(request, Person.class)));
//    }

    @Override
    protected ICrudService<Person, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
