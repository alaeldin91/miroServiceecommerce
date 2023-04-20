package com.alaeldin.ecommercebackend.product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private String errorCode;
}
