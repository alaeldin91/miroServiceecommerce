package com.alaeldin.ecommercebackend.product.dto;

import com.alaeldin.ecommercebackend.product.entity.ProductCategory;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
private long id;
private ProductCategory category;
private long category_id;
private String sku;
private String name;
private String description;
private int unitPrice;
private String imageUrl;
private boolean active;
private  int unitInStock;
private Date dateCreated;
private Date lastUpdated;

}
