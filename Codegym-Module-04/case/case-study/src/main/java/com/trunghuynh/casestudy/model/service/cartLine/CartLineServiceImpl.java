package com.trunghuynh.casestudy.model.service.cartLine;

import com.trunghuynh.casestudy.model.entity.CartLine;
import com.trunghuynh.casestudy.model.repository.CartLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartLineServiceImpl implements CartLineService {

    private final CartLineRepository cartLineRepository;


    @Override
    public List<CartLine> findAllByCartId(Long cartId) {
        return cartLineRepository.findAllByCartId(cartId);
    }

    @Override
    public void save(CartLine cartLine) {
        cartLineRepository.save(cartLine);
    }

    @Override
    public void update(CartLine cartLine) {
        cartLineRepository.save(cartLine);
    }

    @Override
    public void deleteCartLineById(Long cartLineId) {
        cartLineRepository.deleteById(cartLineId);
    }
}
