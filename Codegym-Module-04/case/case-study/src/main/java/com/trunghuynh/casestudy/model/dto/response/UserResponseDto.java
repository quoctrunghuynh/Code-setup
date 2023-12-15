package com.trunghuynh.casestudy.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String userImgUrl;
    private Boolean gender;
    private Date joinDate;
    private String telephone;
    private List<AddressResponseDto> address;
}
