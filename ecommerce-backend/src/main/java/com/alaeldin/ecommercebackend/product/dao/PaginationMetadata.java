package com.alaeldin.ecommercebackend.product.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationMetadata {
    private int pageNumber;
    private int pageSize;
    private int totalElements;
}
