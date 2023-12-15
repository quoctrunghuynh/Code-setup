package com.trunghuynh.casestudy.model.service.cart;

import com.trunghuynh.casestudy.model.dto.response.CartLineResponseDto;
import com.trunghuynh.casestudy.model.entity.Cart;
import com.trunghuynh.casestudy.model.entity.CartLine;

import java.util.List;
import java.util.Optional;

public interface CartService {
    void addCart(Cart cart);

    List<CartLine> getAllProductFromCart(Long userId);
    List<CartLineResponseDto> getAllCartLineDtoByUserId(Long userId);

    Optional<Cart> findByUserId(Long userId);

    void updateCart(Cart cart);

    void deleteCartById(Long cartId);

    void addProductToCart(Long userId, Long productId, Long quantity);

}