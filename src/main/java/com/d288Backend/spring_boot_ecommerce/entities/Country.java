package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Data
@Getter
@Setter
@NoArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id", nullable = false)
    private Long id;

    @Column(name="country", nullable = false)
    private String country_name;

    @Column(name="create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update", nullable = false)
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions = new HashSet<>();
}
