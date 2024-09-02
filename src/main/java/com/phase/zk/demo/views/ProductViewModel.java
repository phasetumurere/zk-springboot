package com.phase.zk.demo.views;

import com.phase.zk.demo.model.Product;
import com.phase.zk.demo.service.impl.ProductService;
import org.zkoss.bind.annotation.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class ProductViewModel {

    @WireVariable
    private final ProductService productService;

    private List<Product> products;

    public ProductViewModel(ProductService productService) {
        this.productService = productService;
    }

    @Init
    public void init() {
        products = productService.getAllProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
