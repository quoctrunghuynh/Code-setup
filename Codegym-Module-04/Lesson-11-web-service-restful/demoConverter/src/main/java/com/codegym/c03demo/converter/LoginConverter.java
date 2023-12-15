package com.codegym.c03demo.converter;

import com.codegym.c03demo.dto.AddressResponseDto;
import com.codegym.c03demo.dto.LoginResponseDto;
import com.codegym.c03demo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class LoginConverter implements Function<User, LoginResponseDto> {

   private AddressConverter addressConverter;

    public LoginResponseDto apply(User user){
        LoginResponseDto responseDto = new LoginResponseDto();
        BeanUtils.copyProperties(user, responseDto);
        AddressResponseDto addressResponseDto = addressConverter.entityToDto(user.getAddress());
        responseDto.setAddress(addressResponseDto);
        return responseDto;
    }
}
