package com.d288Backend.spring_boot_ecommerce.services;

public interface CheckoutServiceInterface {
    PurchaseResponse placeOrder(Purchase purchase);
}
