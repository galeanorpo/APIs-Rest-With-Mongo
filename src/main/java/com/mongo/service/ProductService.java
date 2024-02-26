package com.mongo.service;

import com.mongo.domain.Product;
import com.mongo.dto.ProductDto;
import com.mongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return this.repository.findAll();
    }

    public void createProduct(ProductDto productDto){
        Product product = new Product(
                productDto.getId(),
                productDto.getImagePath(),
                productDto.getTitle(),
                productDto.getDescription()
        );
        this.repository.save(product);
    }

    public void updateProduct(Long productId, ProductDto productDto){
        Product product = this.repository.findById(productId).get();
        if(product != null){
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setImagePath(productDto.getImagePath());
            this.repository.save(product);
        }
    }

    public void deleteProduct(Long productId){
        Product product = this.repository.findById(productId).get();
        if(product != null){
            this.repository.deleteById(product.getId());
        }
    }
}
