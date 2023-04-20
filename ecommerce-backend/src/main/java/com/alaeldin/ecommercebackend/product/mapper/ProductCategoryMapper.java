package com.alaeldin.ecommercebackend.product.mapper;

import com.alaeldin.ecommercebackend.product.dto.ProductCategoryDto;
import com.alaeldin.ecommercebackend.product.entity.ProductCategory;

public class ProductCategoryMapper {
    public static ProductCategoryDto mapToProductCategoryDto(ProductCategory productCategory){
         ProductCategoryDto productCategoryDto = new ProductCategoryDto(productCategory.getId()
                 ,productCategory.getCategoryName(),
                 productCategory.getProducts());
         return  productCategoryDto;

    }
    public static  ProductCategory mapToProductCategory(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory(productCategoryDto.getId()
                ,productCategoryDto.getCategoryName(),
                productCategoryDto.getProducts());
        return productCategory;
    }
}
