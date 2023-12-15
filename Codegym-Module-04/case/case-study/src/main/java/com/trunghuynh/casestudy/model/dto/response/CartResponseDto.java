package com.trunghuynh.casestudy.model.dto.response;

import com.trunghuynh.casestudy.model.entity.CartLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private Long id;
    private Long userId;
    private Double totalPrice;
    private List<CartLine> cartLines;
    private int quantity;
    private String status;
}
