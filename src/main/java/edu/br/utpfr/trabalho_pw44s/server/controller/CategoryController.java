package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.dto.CategoryRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.CategoryResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Category;
import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.service.ICategoryService;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController extends CrudController<Category, CategoryRequestDto, CategoryResponseDto, Long> {

    private final ICategoryService service;
    private final ModelMapper mapper;

    public CategoryController(ICategoryService service,
                              ModelMapper mapper) {
        super(Category.class, CategoryResponseDto.class, CategoryRequestDto.class);
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/find")
    public ResponseEntity<List<Category>> getProducts(@RequestParam(value = "isTop", required = false) Boolean top) {
        List<Category> topCategories = service.getCategories(top);
        return ResponseEntity.ok(topCategories);
    }


    @Override
    protected ICrudService<Category, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
