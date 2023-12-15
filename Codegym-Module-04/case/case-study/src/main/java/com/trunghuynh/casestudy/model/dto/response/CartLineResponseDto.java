package com.trunghuynh.casestudy.model.dto.response;

import com.trunghuynh.casestudy.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartLineResponseDto {
    private Long id;
    private Long cartId;
    private Long productId;
    private Long quantity;
    private Long subPrice;
}
