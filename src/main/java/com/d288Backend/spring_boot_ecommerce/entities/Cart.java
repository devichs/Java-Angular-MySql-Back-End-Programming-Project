package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Data

public class Cart {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id", nullable = false)
    private Long cart_id;

    @Column(name="package_price", nullable = false)
    private BigDecimal package_price;

    @Column(name="party_size", nullable = false)
    private Integer party_size;

    @Setter
    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Setter
    @Column(name="order_tracking_number", nullable = false)
    private String orderTrackingNumber;

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

}
