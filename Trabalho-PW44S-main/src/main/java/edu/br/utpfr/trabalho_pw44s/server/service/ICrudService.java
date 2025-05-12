package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ICrudService<T, ID extends Serializable> {
    List<T> findAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    T save(T entity);

    T updatePartialById(ID id, Map<String, Object> updates);

    List<T> save(Iterable<T> iterable);

    T findById(ID id);

    boolean exists(ID id);

    long count();

    void delete(ID id);

    void delete(Iterable<? extends T> iterable);
}
