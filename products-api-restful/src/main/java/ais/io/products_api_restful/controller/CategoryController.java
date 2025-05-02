package ais.io.products_api_restful.controller;

import ais.io.products_api_restful.dto.CategoryDTO;
import ais.io.products_api_restful.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/ais.io/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryDTO = categoryService.insert(categoryDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> result = categoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable UUID uuid) {
        CategoryDTO categoryDTO = categoryService.findById(uuid);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping(value = "{uuid}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID uuid) {
        categoryService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

}
