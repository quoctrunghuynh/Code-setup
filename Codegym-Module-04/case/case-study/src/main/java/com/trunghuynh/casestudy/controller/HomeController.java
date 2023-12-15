package com.trunghuynh.casestudy.controller;

import com.trunghuynh.casestudy.model.dto.response.AddressResponseDto;
import com.trunghuynh.casestudy.model.dto.response.CommonResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(){
        return "/home-page";
    }

//    @GetMapping("/asdasdsa")
//    public CommonResponseDto<AddressResponseDto> getAddress() {
//        AddressResponseDto addressResponseDto = new AddressResponseDto();
//        CommonResponseDto<AddressResponseDto> commonResponseDto = new CommonResponseDto<>();
//        commonResponseDto.setData(addressResponseDto);
//        return commonResponseDto;
//    }
}
