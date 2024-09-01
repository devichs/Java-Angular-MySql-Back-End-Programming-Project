package com.d288Backend.spring_boot_ecommerce.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
