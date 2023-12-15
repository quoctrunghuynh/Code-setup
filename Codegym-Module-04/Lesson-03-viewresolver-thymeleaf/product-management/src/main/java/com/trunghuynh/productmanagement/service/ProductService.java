package com.trunghuynh.productmanagement.service;

import com.trunghuynh.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Map<Long, Product> products;

    static {
        products = new HashMap<>();
        products.put(1L, new Product(1L,"Egg pack", "a dozen eggs", 55.000));
        products.put(2L, new Product(2L,"Chicken-wing set", "4 wings", 20.000));
        products.put(3L, new Product(3L,"Chicken-thigh set", "4 thighs", 22.000));
        products.put(4L, new Product(4L,"Chicken-breast set", "2 big breast of chicken", 26.000));
        products.put(5L, new Product(5L,"Chicken-dinner pack", "2 eggs, 2 wings, 2 thighs, 1 breast", 50.000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put((product.getId()), product);
    }

    @Override
    public void update(Long id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Long id) {
        products.remove(id);
    }
}
