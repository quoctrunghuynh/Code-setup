package com.trunghuynh.casestudy.model.dto.response;

import com.trunghuynh.casestudy.model.entity.Category;
import com.trunghuynh.casestudy.model.entity.Variant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgURL;
    private String brand;
    private boolean availiability;
    private List<CategoryResponseDto> categories;
    private List<VariantResponseDto> variantList;
}
