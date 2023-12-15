package com.codegym.c03demo.service.impl;

import com.codegym.c03demo.converter.EntityToDto;
import com.codegym.c03demo.converter.LoginConverter;
import com.codegym.c03demo.dto.AddressResponseDto;
import com.codegym.c03demo.dto.LoginRequestDto;
import com.codegym.c03demo.dto.LoginResponseDto;
import com.codegym.c03demo.entity.Address;
import com.codegym.c03demo.entity.User;
import com.codegym.c03demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final User user ;

    private Function<User, LoginResponseDto> loginConverter;

    static {
        user = new User();
        user.setId(1);
        user.setUsername("thaidui");
        user.setPassword("thaikodui");
        user.setName("thaicongtu");

        Address address = new Address();
        address.setId(1);
        address.setNumber("21K");
        address.setDistrict("Phu Nhuan");
        address.setStreet("Nguyen Van Troi");
        user.setAddress(address);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        LoginResponseDto responseDto = new LoginResponseDto();
        //User user = userRepository.findByUsername(loginRequestDto.getUsername());
        if(user.getPassword().equals(loginRequestDto.getPassword())){
            responseDto = loginConverter.apply(user);
            return responseDto;
        }
        return null;
    }
}
