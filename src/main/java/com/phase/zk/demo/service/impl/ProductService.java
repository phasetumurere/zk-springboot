package com.phase.zk.demo.service.impl;

import com.phase.zk.demo.model.Product;
import com.phase.zk.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product>products = productRepository.findAll();
        if (products.isEmpty()){
            throw new RuntimeException("No Product Yet");
        }
        return products;
    }
}
