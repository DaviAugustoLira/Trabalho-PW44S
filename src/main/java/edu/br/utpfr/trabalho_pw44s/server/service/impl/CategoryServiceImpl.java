package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.model.Category;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.repository.CategoryRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.PersonRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.ICategoryService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements ICategoryService {
    private final CategoryRepository repository;


    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Category> iterable) {

    }

    @Override
    public List<Category> getCategories(Boolean isTop) {
        if(isTop == null){
            return repository.findAll();
        }
        return repository.findByTop(isTop);
    }
}
