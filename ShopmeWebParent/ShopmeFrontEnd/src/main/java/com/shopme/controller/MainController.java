package com.shopme.controller;

import com.shopme.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", repository.findAll());
        return  "product/products";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
