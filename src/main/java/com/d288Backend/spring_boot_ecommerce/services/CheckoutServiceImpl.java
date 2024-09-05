package com.d288Backend.spring_boot_ecommerce.services;

import com.d288Backend.spring_boot_ecommerce.dao.CartItemRepository;
import com.d288Backend.spring_boot_ecommerce.dao.CartRepository;
import com.d288Backend.spring_boot_ecommerce.entities.Cart;
import com.d288Backend.spring_boot_ecommerce.entities.CartItem;
import com.d288Backend.spring_boot_ecommerce.entities.Customer;
import com.d288Backend.spring_boot_ecommerce.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
}
