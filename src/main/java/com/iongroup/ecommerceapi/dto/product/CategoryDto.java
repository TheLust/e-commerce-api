package com.iongroup.ecommerceapi.dto.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    @NotBlank
    //Unique
    private String name;

    @NotBlank
    private String description;
}
