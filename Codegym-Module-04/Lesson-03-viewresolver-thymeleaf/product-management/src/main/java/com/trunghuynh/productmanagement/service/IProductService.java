package com.trunghuynh.productmanagement.service;

import com.trunghuynh.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void update(Long id, Product product);

    void remove(Long id);
}
