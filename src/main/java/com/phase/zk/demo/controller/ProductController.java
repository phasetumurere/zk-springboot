package com.phase.zk.demo.controller;

import com.phase.zk.demo.model.Product;
import com.phase.zk.demo.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/product/list")
    public List<Product> showProductList() {
        return service.getAllProducts(); // Returns product_list.zul
    }
}
