package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.CategoryResponseDto;
import com.trunghuynh.casestudy.model.dto.response.ProductResponseDto;
import com.trunghuynh.casestudy.model.dto.response.VariantResponseDto;
import com.trunghuynh.casestudy.model.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductMapper implements GeneralMapper<Product,ProductResponseDto> {

    private final CategoryMapper categoryMapper;
    private final VariantMapper variantMapper;

    @Override
    public ProductResponseDto convert(Product source) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(source, productResponseDto);
        List<VariantResponseDto> variantResponseDto = variantMapper.convert(source.getVariantList());
        List<CategoryResponseDto> categoryResponseDto = categoryMapper.convert(source.getCategories());
        productResponseDto.setVariantList(variantResponseDto);
        productResponseDto.setCategories(categoryResponseDto);
        return productResponseDto;
    }

    @Override
    public Product revert(ProductResponseDto target) {
        Product result = new Product();
        BeanUtils.copyProperties(target, result);
        return result;
    }

    @Override
    public List<ProductResponseDto> convert(List<Product> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<Product> revert(List<ProductResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
