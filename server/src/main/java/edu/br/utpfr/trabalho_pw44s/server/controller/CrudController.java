package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class CrudController <T, E, R, ID extends Serializable> {

    protected abstract ICrudService<T, ID> getService();

    protected abstract ModelMapper getModelMapper();

    private final Class<T> typeClass;
    private final Class<R> typeResponseDto;
    private final Class<E> typeRequestDto;


    private R convertEntityToResponse(T entity) {
        return getModelMapper().map(entity, this.typeResponseDto);
    }
    private T convertReponseToEntity(R entityDto) {
        return getModelMapper().map(entityDto, this.typeClass);
    }

    private E convertEntityToRequest(T entity) {
        return getModelMapper().map(entity, this.typeRequestDto);
    }
    private T convertRequestToEntity(E entityDto) {
        return getModelMapper().map(entityDto, this.typeClass);
    }

    private R convertRequestToResponse(E entityDto) {
        return getModelMapper().map(entityDto, this.typeResponseDto);
    }

    private E convertResponseToRequest(R entityDto) {
        return getModelMapper().map(entityDto, this.typeRequestDto);
    }


    @PostMapping
    public ResponseEntity<R> save(@RequestBody @Valid E request){
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(entity.getId())
//                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(convertEntityToResponse(getService().save(convertRequestToEntity(request))));
    }

    @PatchMapping("{id}")
    public ResponseEntity<R> update(@PathVariable ID id,
                                                    @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok().body(convertEntityToResponse(getService().updatePartialById(id, updates)));
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll(){
        return ResponseEntity.ok(this.getService().findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<T> findById(@PathVariable ID id){
        return ResponseEntity.ok(this.getService().findById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id){
        this.getService().delete(id);
    }

    @GetMapping("exists/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable ID id){
        return ResponseEntity.ok().body(getService().exists(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok().body(getService().count());
    }
}
