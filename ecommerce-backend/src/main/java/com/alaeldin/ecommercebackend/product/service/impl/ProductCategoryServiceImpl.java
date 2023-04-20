package com.alaeldin.ecommercebackend.product.service.impl;

import com.alaeldin.ecommercebackend.product.dao.ProductCategoryRepository;
import com.alaeldin.ecommercebackend.product.dto.ProductCategoryDto;
import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.entity.Product;
import com.alaeldin.ecommercebackend.product.entity.ProductCategory;
import com.alaeldin.ecommercebackend.product.exception.ResourceNotFoundException;
import com.alaeldin.ecommercebackend.product.mapper.ProductCategoryMapper;
import com.alaeldin.ecommercebackend.product.mapper.ProductMapper;
import com.alaeldin.ecommercebackend.product.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategoryDto> getAllProducts() {
        List<ProductCategory> productCategoryList  = productCategoryRepository.findAll();
        PageRequest pageable = PageRequest.of(0, productCategoryList.size());
        List<ProductCategoryDto>productCategoryDtoList = productCategoryList.stream().map(productCategory
                -> ProductCategoryMapper.mapToProductCategoryDto(productCategory)).toList();
        return productCategoryDtoList;
    }

    @Override
    public ProductCategoryDto getProductCategoryById(long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException(
                "productCategory","id",id
        ));
        ProductCategoryDto productCategoryDto = ProductCategoryMapper.mapToProductCategoryDto(productCategory);
        return productCategoryDto;
    }


}
