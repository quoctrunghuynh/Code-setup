package com.trunghuynh.casestudy.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariantResponseDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Integer quantity;
    private double weight;
}
