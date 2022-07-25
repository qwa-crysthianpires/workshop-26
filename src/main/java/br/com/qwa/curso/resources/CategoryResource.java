package br.com.qwa.curso.resources;


import br.com.qwa.curso.entities.Category;
import org.springframework.http.ResponseEntity;
import br.com.qwa.curso.services.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity <List<Category>> findALl(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
       Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
