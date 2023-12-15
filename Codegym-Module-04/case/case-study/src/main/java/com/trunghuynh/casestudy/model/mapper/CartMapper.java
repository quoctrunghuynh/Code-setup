package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.CartLineResponseDto;
import com.trunghuynh.casestudy.model.dto.response.CartResponseDto;
import com.trunghuynh.casestudy.model.entity.Cart;
import com.trunghuynh.casestudy.model.entity.CartLine;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class CartMapper implements GeneralMapper<Cart, CartResponseDto>{
    @Override
    public CartResponseDto convert(Cart source) {
        CartResponseDto cartResponseDto = new CartResponseDto();
        BeanUtils.copyProperties(source, cartResponseDto);
        return cartResponseDto;
    }

    @Override
    public Cart revert(CartResponseDto target) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(target, cart);
        return cart;
    }

    @Override
    public List<CartResponseDto> convert(List<Cart> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<Cart> revert(List<CartResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
