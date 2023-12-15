package com.trunghuynh.casestudy.model.service.cartLine;

import com.trunghuynh.casestudy.model.entity.CartLine;

import java.util.List;

public interface CartLineService {
    List<CartLine> findAllByCartId(Long id);

    void save(CartLine cartLine);

    void update(CartLine cartLine);

    void deleteCartLineById(Long cartLineId);
}
