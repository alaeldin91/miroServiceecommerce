package com.alaeldin.ecommercebackend.product.service.impl;

import com.alaeldin.ecommercebackend.product.dao.ProductRepository;
import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.entity.Product;
import com.alaeldin.ecommercebackend.product.exception.ResourceNotFoundException;
import com.alaeldin.ecommercebackend.product.mapper.ProductMapper;
import com.alaeldin.ecommercebackend.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductDto> getAllProduct() {
        List<Product>productList = productRepository.findAll();
        PageRequest pageable = PageRequest.of(0,10);

        List<ProductDto> productDtoList =  productList.stream().map(product
                -> ProductMapper.mapToProductDto(product)).toList();
   return productDtoList;
    }

    @Override
    public ProductDto getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "product","productId",id));
        ProductDto productDto = ProductMapper.mapToProductDto(product);
        return productDto;
    }

    @Override
    public Page<ProductDto> getProductByCategory(long categoryId,int page,  int size) {
        Pageable pageable = PageRequest.of(page, size);

        List<Product> products = productRepository.findByCategory_id(categoryId).orElseThrow(()->
                new ResourceNotFoundException("product","categoryId",categoryId));
        List<Product> productList = productRepository.findByCategory_id(categoryId,pageable)
             .orElseThrow(()->new ResourceNotFoundException(
             "product","categoryId",categoryId
     ));

        Page<ProductDto>productDtoList = new PageImpl<>(productList.stream().map(product
                -> ProductMapper.mapToProductDto(product)).toList(),pageable,products.size());
        if(productDtoList.hasContent()) {
            return productDtoList;
        } else {
            return productDtoList;
        }
    }

    @Override
    public Page<ProductDto> getProductFindByName(String productName,int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
       List<Product> products = productRepository.findByNameContaining(productName).orElseThrow();
        List<Product>productList = productRepository.findByNameContaining(productName,pageable).orElseThrow();
        Page<ProductDto> productDtoList = new PageImpl<>(productList.stream().map(product ->
                ProductMapper.mapToProductDto(product)).toList(),pageable,products.size());
        return productDtoList;
    }


}
