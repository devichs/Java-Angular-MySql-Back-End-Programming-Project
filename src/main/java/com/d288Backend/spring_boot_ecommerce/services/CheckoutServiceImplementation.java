package com.d288Backend.spring_boot_ecommerce.services;

import com.d288Backend.spring_boot_ecommerce.dao.CartItemRepository;
import com.d288Backend.spring_boot_ecommerce.dao.CartRepository;
import com.d288Backend.spring_boot_ecommerce.entities.Cart;
import com.d288Backend.spring_boot_ecommerce.entities.CartItem;
import com.d288Backend.spring_boot_ecommerce.entities.Customer;
import com.d288Backend.spring_boot_ecommerce.entities.StatusType;
import com.d288Backend.spring_boot_ecommerce.services.Purchase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImplementation implements CheckoutServiceInterface {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        // pull the cart and the customer info from the
        // purchase object
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItem();

        // generate a unique order number tracking number
        String orderTrackingNbr = UUID.randomUUID().toString();
        // set the order tracking number
        cart.setOrderTrackingNumber(orderTrackingNbr);
        // set the status of the order
        cart.setStatus(StatusType.ordered);
        // loop through all the cart items and add them to the cart obj
        //cartItem.setCart(cart);
        cartItems.forEach(cart::add);

        // if we have gotten this far then we need to save the data to the db
        cartRepository.save(cart);

        // now return the Purchase response object
        return new PurchaseResponse(orderTrackingNbr);
    }    
        public CheckoutServiceImplementation(CartRepository cartRepository, CartItemRepository cartItemRepository) {
            this.cartRepository = cartRepository;
            this.cartItemRepository = cartItemRepository;
        }
}
