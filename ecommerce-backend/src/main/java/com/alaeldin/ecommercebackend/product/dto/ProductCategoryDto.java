package com.alaeldin.ecommercebackend.product.dto;

import com.alaeldin.ecommercebackend.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategoryDto {
    private long id;
    private String categoryName;

    private Set<Product> products;

}
