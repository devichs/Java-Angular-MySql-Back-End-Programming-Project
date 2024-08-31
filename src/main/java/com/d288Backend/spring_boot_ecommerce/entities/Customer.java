package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "customers")
@Data

public class Customer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id", nullable = false)
    private Long id;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name="customer_first_name", nullable = false)
    private String firstName;

    @Column(name="customer_last_name", nullable = false)
    private String lastName;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="postal_code", nullable = false)
    private String postal_code;

    @ManyToOne
    @JoinColumn(name="division_id", nullable = false, updatable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart_id")
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        carts.add(cart);
    }
}
