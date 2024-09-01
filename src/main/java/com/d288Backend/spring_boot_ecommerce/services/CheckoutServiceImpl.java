package com.d288Backend.spring_boot_ecommerce.services;

import com.d288Backend.spring_boot_ecommerce.dao.CartRepository;
import com.d288Backend.spring_boot_ecommerce.dao.CustomerRepository;
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

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();
        String orderTrackingNumber = generateOrderTrackingNumber();

        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        customer.add(cart);

        cartRepository.save(cart);
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
