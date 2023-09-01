package com.iongroup.ecommerceapi.entity;

import com.iongroup.ecommerceapi.entity.enums.CartStatus;
import com.iongroup.ecommerceapi.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CartStatus status;
}
