package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public abstract class CrudServiceImpl <T, ID extends Serializable> implements ICrudService<T, ID>{

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T updatePartialById(ID id, Map<String, Object> updates){
        T entity = getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        //Percorre as atualizações como chave e valor
        updates.forEach((key, value) -> {
            //Busca um atributo que tenha um nome igual o nome da chave
            Field field = ReflectionUtils.findField(entity.getClass(),  key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entity, value);
        });

        return this.getRepository().save(entity);
    }


    @Override
    public Iterable<T> save(Iterable<T> iterable) {
        return getRepository().saveAll(iterable);
    }


    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public boolean exists(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getRepository().count();
    }

    @Override
    public void delete(ID id) {
        getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found!"));
        getRepository().deleteById(id);
    }

//    @Override
//    public void delete(Iterable<? extends T> iterable) {
//        getRepository().deleteAll(iterable);
//    }
}
