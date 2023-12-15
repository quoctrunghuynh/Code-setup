package com.codegym.c03demo.converter;

import com.codegym.c03demo.dto.AddressResponseDto;
import com.codegym.c03demo.entity.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    public AddressResponseDto entityToDto(Address address){
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        BeanUtils.copyProperties(address, addressResponseDto);
        return addressResponseDto;
    }
}
