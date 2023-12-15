package com.trunghuynh.casestudy.model.service.product;




import com.trunghuynh.casestudy.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProduct();

    Optional<Product> findById(Long id);

    Page<Product> findAllPage(Pageable pageable);
}
