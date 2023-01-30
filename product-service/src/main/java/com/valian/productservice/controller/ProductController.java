package com.valian.productservice.controller;

import com.valian.productservice.dto.ProductRequest;
import com.valian.productservice.dto.ProductResponse;
import com.valian.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProducts();
    }
}
