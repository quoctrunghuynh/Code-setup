package com.trunghuynh.productmanagement.controller;

import com.trunghuynh.productmanagement.model.Product;
import com.trunghuynh.productmanagement.service.IProductService;
import com.trunghuynh.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    private final IProductService productService = new ProductService();

    @GetMapping("/")
    public String getHome(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute(productList);
        return "/home";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "/add-product";
    }

    @PostMapping("/save")
    public String saveProduct(Product product){
        product.setId((long) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("product/{id}/edit")
    public String editProduct(@PathVariable Long id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit-product";
    }

    @PostMapping("product/edit")
    public String updateProduct(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("product/{id}/view")
    public String viewProduct(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/view-product";
    }

    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.remove(id);
        return "redirect:/";
    }
}
