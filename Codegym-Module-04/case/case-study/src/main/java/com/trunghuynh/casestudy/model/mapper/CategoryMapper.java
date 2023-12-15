package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.CategoryResponseDto;
import com.trunghuynh.casestudy.model.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoryMapper implements GeneralMapper<Category,CategoryResponseDto>{

    @Override
    public CategoryResponseDto convert(Category source) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        BeanUtils.copyProperties(source,categoryResponseDto);
        return categoryResponseDto;
    }

    @Override
    public Category revert(CategoryResponseDto target) {
        Category category = new Category();
        BeanUtils.copyProperties(target,category);
        return category;
    }

    @Override
    public List<CategoryResponseDto> convert(List<Category> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<Category> revert(List<CategoryResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
