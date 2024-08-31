package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Data
@NoArgsConstructor

public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation_title")
    private Set<Excursion> excursions = new HashSet<>();

}
