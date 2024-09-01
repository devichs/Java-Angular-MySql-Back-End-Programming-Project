package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id",nullable = false)
    private Long id;

    @Column(name = "excursion_title",nullable = false)
    private String excursion_title;

    @Column(name = "excursion_price",nullable = false)
    private BigDecimal excursion_price;

    @Column(name = "image_url",nullable = false)
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation_title;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "excursion_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "cart_item_id", nullable = false)
    )
    private Set<CartItem> cartItems = new HashSet<>();
}
