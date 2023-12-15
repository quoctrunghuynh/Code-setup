package com.trunghuynh.Controller;

import com.trunghuynh.Entity.Product;
import com.trunghuynh.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productService;

    }
}
