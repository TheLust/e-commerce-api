package com.iongroup.ecommerceapi.entity;

import com.iongroup.ecommerceapi.entity.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Cart cart;

    @NotNull
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    @Check(constraints = "quantity > 0")
    private Integer quantity;
}
