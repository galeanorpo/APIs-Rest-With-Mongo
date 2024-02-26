package com.mongo.controller;

import com.mongo.domain.Product;
import com.mongo.dto.ProductDto;
import com.mongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = "application/json")
    public List<Product> getProducts(){
        return this.productService.getAllProducts();
    }

    @PostMapping(value = "/saveProduct")
    public ResponseEntity  saveProduct(@RequestBody ProductDto productDto){
        this.productService.createProduct(productDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto){
        this.productService.updateProduct(productId, productDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId){
        this.productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
