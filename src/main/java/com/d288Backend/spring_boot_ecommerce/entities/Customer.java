package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import java.util.Collection;

@Entity
@Table(name = "customers")
@Data

public class Customer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "address")
    private VarcharJdbcType address;

    @Column(name = "customer_first_name")
    private VarcharJdbcType customer_first_name;

    @Column(name = "customer_last_name")
    private VarcharJdbcType customer_last_name;

    @Column(name = "phone")
    private VarcharJdbcType phone;

    @Column(name = "postal_code")
    private VarcharJdbcType postal_code;

    @Column(name = "division_id")
    private Long division_id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Long create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Long last_update;

    @Setter
    @Getter
    @OneToMany(mappedBy = "customer_id")
    private Collection<Cart> carts;

}
