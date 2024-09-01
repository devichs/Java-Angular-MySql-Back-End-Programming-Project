package com.d288Backend.spring_boot_ecommerce.services;

import com.d288Backend.spring_boot_ecommerce.entities.Cart;
import com.d288Backend.spring_boot_ecommerce.entities.CartItem;
import com.d288Backend.spring_boot_ecommerce.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
