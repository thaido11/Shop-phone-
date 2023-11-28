package com.shopme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/carts")
    public String cart() {
        return "cart/carts";
    }
}
