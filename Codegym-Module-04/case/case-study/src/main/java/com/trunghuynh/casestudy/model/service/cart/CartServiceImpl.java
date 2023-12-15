package com.trunghuynh.casestudy.model.service.cart;

import com.trunghuynh.casestudy.model.dto.response.CartLineResponseDto;
import com.trunghuynh.casestudy.model.entity.Cart;
import com.trunghuynh.casestudy.model.entity.CartLine;
import com.trunghuynh.casestudy.model.entity.Product;
import com.trunghuynh.casestudy.model.entity.user.User;
import com.trunghuynh.casestudy.model.mapper.CartLineMapper;
import com.trunghuynh.casestudy.model.repository.CartLineRepository;
import com.trunghuynh.casestudy.model.repository.CartRepository;
import com.trunghuynh.casestudy.model.repository.ProductRepository;
import com.trunghuynh.casestudy.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartLineRepository cartLineRepository;
    private final ProductRepository productRepository;
    private final CartLineMapper cartLineMapper;

    @Override
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<CartLine> getAllProductFromCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("Invalid userId"));
        return cartLineRepository.findAllByCartId(cart.getId());
    }

    @Override
    public List<CartLineResponseDto> getAllCartLineDtoByUserId(Long userId) {
        List<CartLine> cartLineList = getAllProductFromCart(userId);
        return cartLineMapper.convert(cartLineList);
    }

    @Override
    public Optional<Cart> findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCartById(Long cart) {
        cartRepository.deleteById(cart);
    }

    @Override
    @Transactional
    public void addProductToCart(Long userId, Long productId, Long quantity) {
        //Get Cart
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid userId"));
        Cart currentCart = user.getCart();
        if (ObjectUtils.isEmpty(currentCart)) {
            currentCart = new Cart();
            currentCart.setUser(user);
            currentCart.setCartLines(new ArrayList<>());
            user.setCart(currentCart);
            cartRepository.save(currentCart);
        }
        //From cart get cart item list
        List<CartLine> cartLineList = currentCart.getCartLines();
        //Create cart item then add into cart item list
        Product product = productRepository.findById(productId).orElse(null);
        CartLine cartLine = CartLine.builder()
                .cart(currentCart)
                .product(product)
                .quantity(quantity)
                .build();
        //Create new cartline add to that list
        cartLineList.add(cartLine);
        //Save cart
        cartLineRepository.save(cartLine);
    }
}
