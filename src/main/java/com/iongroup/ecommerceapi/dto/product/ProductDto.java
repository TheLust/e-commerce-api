package com.iongroup.ecommerceapi.dto.product;

import com.iongroup.ecommerceapi.constants.ConstraintViolationMessage;
import com.iongroup.ecommerceapi.entity.enums.DiscountType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    @NotBlank(message = "Title" + ConstraintViolationMessage.NOT_BLANK)
    private String title;

    private CategoryDto category;

    @NotNull(message = "Inventory" + ConstraintViolationMessage.NOT_NULL)
    @Min(value = 0, message = "Inventory" + ConstraintViolationMessage.MIN)
    private Integer inventory;

    @NotBlank(message = "Summary" + ConstraintViolationMessage.NOT_BLANK)
    private String summary;

    private byte[] picture;

    @NotNull(message = "Price" + ConstraintViolationMessage.NOT_BLANK)
    @Min(value = 0, message = "Price" + ConstraintViolationMessage.MIN)
    private Double price;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Double discount;
}
