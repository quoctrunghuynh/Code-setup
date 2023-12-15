package com.databinding.demodatabinding.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String contactNumber;
}
