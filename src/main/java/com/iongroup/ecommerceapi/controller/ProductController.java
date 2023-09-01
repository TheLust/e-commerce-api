package com.iongroup.ecommerceapi.controller;

import com.iongroup.ecommerceapi.constants.Route;
import com.iongroup.ecommerceapi.dto.product.ProductDto;
import com.iongroup.ecommerceapi.facade.ProductFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Route.API_DEFAULT_ROUTE)
@AllArgsConstructor
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping("/categories/{category_id}/products")
    public ResponseEntity<List<ProductDto>> findAll(@PathVariable("category_id") Long categoryId) {
        return new ResponseEntity<>(
                productFacade.findAll(categoryId),
                HttpStatus.OK
        );
    }

    @PostMapping("/categories/{category_id}/products")
    public ResponseEntity<ProductDto> save(@PathVariable("category_id") Long categoryId,
                                           @RequestBody @Valid ProductDto productDto,
                                           BindingResult bindingResult) {
        return new ResponseEntity<>(
                productFacade.save(categoryId, productDto, bindingResult),
                HttpStatus.OK
        );
    }
}
