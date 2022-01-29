package com.example.docker.controller;

import com.example.docker.dto.Member;
import com.example.docker.dto.Product;
import com.example.docker.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/v1.0/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {

        return ResponseEntity.ok(Product.builder()
                        .id(productId)
                        .name("혈압계")
                        .type("파손위험")
                .build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/api/v1.0/product")
    public ResponseEntity<Result> setProduct(@RequestBody Product product) {

        return ResponseEntity.ok(Result.builder()
                        .code(0)
                        .description("success")
                .build());
    }
}
