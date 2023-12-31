package com.trunghuynh.productmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
public class Product {
    private Long id;
    private String name;
    private String detail;
    private double price;

    public Product() {
    }

    public Product(String name, String detail, double price) {
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public Product(Long id, String name, String detail, double price) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
