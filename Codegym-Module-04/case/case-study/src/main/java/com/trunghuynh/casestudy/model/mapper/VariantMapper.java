package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.response.VariantResponseDto;
import com.trunghuynh.casestudy.model.entity.Address;
import com.trunghuynh.casestudy.model.entity.Variant;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VariantMapper implements GeneralMapper<Variant,VariantResponseDto>{

    @Override
    public VariantResponseDto convert(Variant source) {
        VariantResponseDto variantResponseDto = new VariantResponseDto();
        BeanUtils.copyProperties(source,variantResponseDto);
        return variantResponseDto;
    }

    @Override
    public Variant revert(VariantResponseDto target) {
        Variant variant = new Variant();
        BeanUtils.copyProperties(target, variant);
        return variant;
    }

    @Override
    public List<VariantResponseDto> convert(List<Variant> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<Variant> revert(List<VariantResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
