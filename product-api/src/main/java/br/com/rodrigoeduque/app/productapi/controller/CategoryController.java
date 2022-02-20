package br.com.rodrigoeduque.app.productapi.controller;

import br.com.rodrigoeduque.app.productapi.dto.CategoryDto;
import br.com.rodrigoeduque.app.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {

        CategoryDto category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getCategoryAll() {

        List<CategoryDto> categories = categoryService.getCategoryAll();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping("/category")
    public ResponseEntity<?> newCategory(@RequestBody CategoryDto categoryDto) {

        categoryService.save(categoryDto);
        URI uri = UriComponentsBuilder.fromPath("api/products/category/{id}").buildAndExpand((categoryDto.convertToModel()).getId()).toUri();
        return ResponseEntity.created(uri).body(categoryDto);
    }


    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {

        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
