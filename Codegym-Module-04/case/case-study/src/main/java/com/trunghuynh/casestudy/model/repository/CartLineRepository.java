package com.trunghuynh.casestudy.model.repository;

import com.trunghuynh.casestudy.model.entity.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine,Long> {
    List<CartLine> findAllByCartId(Long cartId);

    void deleteById(Long cartLineId);
}
