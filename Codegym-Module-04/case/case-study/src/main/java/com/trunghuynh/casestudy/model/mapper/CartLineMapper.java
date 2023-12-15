package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.CartLineResponseDto;
import com.trunghuynh.casestudy.model.entity.CartLine;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartLineMapper implements GeneralMapper<CartLine, CartLineResponseDto>{
    @Override
    public CartLineResponseDto convert(CartLine source) {
        CartLineResponseDto cartLineResponseDto = new CartLineResponseDto();
        BeanUtils.copyProperties(source, cartLineResponseDto);
        cartLineResponseDto.setCartId(source.getId());
        cartLineResponseDto.setProductId((source.getProduct()).getId());
        return cartLineResponseDto;
    }

    @Override
    public CartLine revert(CartLineResponseDto target) {
        CartLine cartLine = new CartLine();
        BeanUtils.copyProperties(target, cartLine);
        return cartLine;
    }

    @Override
    public List<CartLineResponseDto> convert(List<CartLine> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<CartLine> revert(List<CartLineResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
