package com.d288Backend.spring_boot_ecommerce.controllers;

import com.d288Backend.spring_boot_ecommerce.services.CheckoutService;
import com.d288Backend.spring_boot_ecommerce.services.PurchaseData;
import com.d288Backend.spring_boot_ecommerce.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")

public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData){
        return checkoutService.placeOrder(purchaseData);
    }
}
