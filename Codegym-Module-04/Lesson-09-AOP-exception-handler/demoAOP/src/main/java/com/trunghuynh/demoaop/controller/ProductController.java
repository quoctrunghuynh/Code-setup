package com.trunghuynh.demoaop.controller;

import com.trunghuynh.demoaop.model.Product;
import com.trunghuynh.demoaop.service.impl.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView showProduct(@PageableDefault(size = 5,sort = "price") Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("shopping");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
