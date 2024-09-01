package com.d288Backend.spring_boot_ecommerce.controllers;

import com.d288Backend.spring_boot_ecommerce.services.CheckoutService;
import com.d288Backend.spring_boot_ecommerce.services.Purchase;
import com.d288Backend.spring_boot_ecommerce.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")

public class CheckoutController {
    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return checkoutService.placeOrder(purchase);
    }
}
