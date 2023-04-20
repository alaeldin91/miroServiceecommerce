package com.alaeldin.ecommercebackend.product.mapper;

import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.entity.Product;

public class ProductMapper {

public static ProductDto mapToProductDto(Product product){
    ProductDto productDto = new ProductDto(product.getId()
            ,product.getCategory(),
            product.getCategory_id(),
            product.getSku(),
            product.getName(),
            product.getDescription(),
            product.getUnitPrice(),
            product.getImageUrl(),
            product.isActive(),
            product.getUnitInStock(),
            product.getDateCreated(),
            product.getLastUpdated());
return  productDto;
}
public static  Product mapProduct(ProductDto productDto){
    Product product = new Product(
            productDto.getId(),
            productDto.getCategory(),
            productDto.getCategory_id(),
            productDto.getSku(),
            productDto.getName(),
            productDto.getDescription(),
            productDto.getUnitPrice(),
            productDto.getImageUrl(),
            productDto.isActive(),
            productDto.getUnitInStock(),
            productDto.getDateCreated(),
            productDto.getLastUpdated());
    return  product;
}
}
