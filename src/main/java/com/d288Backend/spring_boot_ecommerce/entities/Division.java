package com.d288Backend.spring_boot_ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Data

public class Division {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    /*
    division name
    @String
     */
    @Column(name = "division")
    private String division_name;

    /*
    Create time stamp
    @Datetime
     */
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    /*
    update datetime stamp for the table
    @Datetime
     */
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    /*
    Country ID
    @Long
     */
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long countryID;

    /*
    mapping to other tables
     */
    /*
    Country map
     */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    /*
    Set of customers
     */
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;


    public void setCountry(Country country){
        this.country = country;
        this.countryID = (country != null) ? country.getId() : null ;
    }

}
