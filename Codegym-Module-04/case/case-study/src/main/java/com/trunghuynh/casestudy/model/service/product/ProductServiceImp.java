package com.trunghuynh.casestudy.model.service.product;


import com.trunghuynh.casestudy.model.entity.Product;
import com.trunghuynh.casestudy.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public Page<Product> findAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
