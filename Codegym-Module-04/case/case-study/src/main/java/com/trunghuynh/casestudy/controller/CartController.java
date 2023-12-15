package com.trunghuynh.casestudy.controller;

import com.trunghuynh.casestudy.model.dto.response.CartLineResponseDto;
import com.trunghuynh.casestudy.model.entity.CartLine;
import com.trunghuynh.casestudy.model.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/{userId}/add/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable("userId") Long userId,
                                              @PathVariable("productId") Long productId,
                                              @RequestBody Long quantity){
        cartService.addProductToCart(userId,productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/get")
    public ResponseEntity<?> getAllProductFromCart(@PathVariable("userId") Long userId){
        List<CartLineResponseDto>cartLineDtoList = cartService.getAllCartLineDtoByUserId(userId);
        if (cartLineDtoList != null){
            return new ResponseEntity<>(cartLineDtoList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}