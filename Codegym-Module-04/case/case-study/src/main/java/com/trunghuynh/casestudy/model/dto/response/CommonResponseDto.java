package com.trunghuynh.casestudy.model.dto.response;

public class CommonResponseDto<T> {
    private Boolean status;
    private String message;

    private T data;
}
