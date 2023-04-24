package com.alaeldin.ecommercebackend.product.Controller;

import com.alaeldin.ecommercebackend.product.dto.ProductDto;
import com.alaeldin.ecommercebackend.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
    List<ProductDto> productDtoList = productService.getAllProduct();
    return new ResponseEntity<>(productDtoList, HttpStatus.OK);
}
@GetMapping(
        value = "/{categoryId}",
        params = { "page", "size"})
public  ResponseEntity<Page<ProductDto>> getProductByCategory(@PathVariable("categoryId")
                                                              long categoryId,@RequestParam("page") int page
                                                              , @RequestParam("size") int size){
        Page<ProductDto> productDtoList = productService.getProductByCategory(categoryId,page,size);
         return new ResponseEntity<>(productDtoList,HttpStatus.OK);
}
@GetMapping(value = "search/{productName}",params ={"page","size"})
public ResponseEntity<Page<ProductDto>> getProductByName(@PathVariable("productName") String productName
                                                       ,@RequestParam("page") int page,@RequestParam("size") int size){
        Page<ProductDto> productDtoList = productService.getProductFindByName(productName,page,size);
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
}
@GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long id) {
    ProductDto productDto = productService.getProductById(id);
    return new ResponseEntity<>(productDto,HttpStatus.OK);
}

}

