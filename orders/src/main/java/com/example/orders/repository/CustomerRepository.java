package com.example.orders.repository;

import com.example.orders.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository()
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String email);
}
