package com.example.orders.repository;

import com.example.orders.entity.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    Optional<List<Orders>> findByCustomerEmail(String email, Pageable pageable);
    Optional<List<Orders>> findByCustomerEmailContaining(String email);

}
