package com.iongroup.ecommerceapi.controller;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.service.product.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(
                categoryService.findAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody @Valid Category category, BindingResult bindingResult) {

        categoryService.save(category);

        return ResponseEntity.ok("Saved");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id,
                                                 @RequestBody @Valid Category category) {
        Optional<Category> actualCategory = categoryService.findById(id);

        if (actualCategory.isEmpty()) {
            return ResponseEntity.ofNullable("bad");
        }

        categoryService.update(actualCategory.get(), category);

        return ResponseEntity.ok("Updated");
    }
}
