package com.alaeldin.ecommercebackend.product.Controller;

import com.alaeldin.ecommercebackend.product.dto.ProductCategoryDto;
import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategoryDto>> getAllProduct(){
        List<ProductCategoryDto> productCategoryDtoList = productCategoryService.getAllProducts();
        return new ResponseEntity<>(productCategoryDtoList,HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<ProductCategoryDto> getProductById(@PathVariable("id")long id){
        ProductCategoryDto productCategoryDto = productCategoryService.getProductCategoryById(id);
        return new ResponseEntity<>(productCategoryDto,HttpStatus.OK);
    }
}
