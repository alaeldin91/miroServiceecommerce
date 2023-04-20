package com.alaeldin.ecommercebackend.product.dao;

import com.alaeldin.ecommercebackend.product.entity.Product;
import com.alaeldin.ecommercebackend.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository()
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
    Optional<List<ProductCategory>> findByCategoryName(String category);

}
