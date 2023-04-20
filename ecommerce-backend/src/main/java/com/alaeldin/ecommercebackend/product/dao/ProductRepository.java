package com.alaeldin.ecommercebackend.product.dao;

import com.alaeldin.ecommercebackend.product.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository()
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findByCategory_id(long  categoryId);

    Optional<List<Product>> findByCategory_id(long  categoryId,Pageable pageable);
    Optional<List<Product>> findByNameContaining(String productName);

    Optional<List<Product>> findByNameContaining(String productName,Pageable pageable);


}
