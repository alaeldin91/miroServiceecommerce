package com.alaeldin.ecommercebackend.product.service;

import com.alaeldin.ecommercebackend.product.dto.ProductCategoryDto;
import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
   List<ProductDto> getAllProduct();
    ProductDto getProductById(long id);
    Page<ProductDto> getProductByCategory(long categoryId,int page,int size);
    Page<ProductDto> getProductFindByName(String productName,int page,int size);

}
