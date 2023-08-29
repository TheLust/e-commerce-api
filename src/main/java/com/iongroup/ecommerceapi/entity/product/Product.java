package com.iongroup.ecommerceapi.entity.product;

import com.iongroup.ecommerceapi.entity.CartItem;
import com.iongroup.ecommerceapi.entity.OrderItem;
import com.iongroup.ecommerceapi.entity.Review;
import com.iongroup.ecommerceapi.entity.Wishlist;
import com.iongroup.ecommerceapi.entity.enums.DiscountType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Inventory inventory;

    @NotNull
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<Wishlist> wishlist;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String summary;

    private byte[] picture;

    @Column(nullable = false)
    @Check(constraints = "price >= 0")
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Check(constraints = "(discount_type = 'NONE' AND discount = 0) " +
            "OR (discount_type = 'PERCENT' AND discount >= 1 AND discount <= 100) " +
            "OR (discount_type = 'AMOUNT' AND discount >= 1 AND discount <= price)")
    private double discount;
}
