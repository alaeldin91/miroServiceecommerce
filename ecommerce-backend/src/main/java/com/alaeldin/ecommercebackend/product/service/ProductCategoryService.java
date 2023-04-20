package com.alaeldin.ecommercebackend.product.service;

import com.alaeldin.ecommercebackend.product.dto.ProductCategoryDto;
import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductCategoryService {
List<ProductCategoryDto> getAllProducts();
ProductCategoryDto getProductCategoryById(long id);


}
