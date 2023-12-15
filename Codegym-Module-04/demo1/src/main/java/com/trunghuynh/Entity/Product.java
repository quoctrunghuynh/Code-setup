package com.trunghuynh.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String image_url;
    private boolean isDeleted;
}
