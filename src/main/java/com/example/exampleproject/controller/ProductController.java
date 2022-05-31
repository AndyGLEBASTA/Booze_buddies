package com.example.exampleproject.controller;

import com.example.exampleproject.model.Product;
import com.example.exampleproject.service.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product-page";
    }
    @GetMapping("/fragments")
    public String getHome(){
        return "main-fragments.html";
    }

//    @GetMapping("/products")
//    public String findAllPr(Model model) {
//        List<Product> products = productService.findAllProducts();
//        Product product = products.get(0);
//        model.addAttribute("product", product);
//        return "product-page";
//    }

}
