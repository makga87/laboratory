package com.example.controller;

import com.example.dto.Product;
import com.example.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

    @GetMapping("/api/v1.0/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {

        log.debug("{}", productId);

        return ResponseEntity.ok(Product.builder()
                .id(productId)
                .name("혈압계")
                .type("파손위험")
                .build());
    }

    @PostMapping("/api/v1.0/product")
    public ResponseEntity<Result> setProduct(@RequestBody Product product) {

        log.debug("{}", product);

        return ResponseEntity.ok(Result.builder()
                .code(0)
                .description("success")
                .build());
    }
}
