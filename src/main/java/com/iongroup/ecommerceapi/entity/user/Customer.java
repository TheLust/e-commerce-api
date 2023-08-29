package com.iongroup.ecommerceapi.entity.user;

import com.iongroup.ecommerceapi.entity.Cart;
import com.iongroup.ecommerceapi.entity.Order;
import com.iongroup.ecommerceapi.entity.Review;
import com.iongroup.ecommerceapi.entity.Wishlist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Credentials credentials;

    @OneToOne
    private CustomerAddress address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    private List<Cart>  carts;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @OneToMany(mappedBy = "customer")
    private List<Wishlist> wishlist;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}
