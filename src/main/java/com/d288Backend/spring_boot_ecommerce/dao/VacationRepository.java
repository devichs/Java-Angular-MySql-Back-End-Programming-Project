package com.d288Backend.spring_boot_ecommerce.dao;

import com.d288Backend.spring_boot_ecommerce.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}