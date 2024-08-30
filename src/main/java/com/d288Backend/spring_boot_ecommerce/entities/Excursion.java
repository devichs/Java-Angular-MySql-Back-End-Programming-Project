package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Data

public class Excursion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long excursion_id;

    @Column(name = "excursion_title")
    private VarcharJdbcType excursion_title;

    @Column(name = "image_url")
    private VarcharJdbcType image_url;

    @Column(name = "description")
    private VarcharJdbcType description;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation_id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns=@JoinColumn(name="excursion_id", nullable = false),
            inverseJoinColumns=@JoinColumn(name="cart_item_id", nullable = false)
    )
    private Set<CartItem> cartItems = new HashSet<>();


}
