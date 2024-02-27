package com.chungtau.springboottemplate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungtau.springboottemplate.exception.EntityRuntimeException;
import com.chungtau.springboottemplate.model.cart.Cart;
import com.chungtau.springboottemplate.model.cart.CreateCartInput;
import com.chungtau.springboottemplate.model.user.User;
import com.chungtau.springboottemplate.repository.CartRepository;
import com.chungtau.springboottemplate.repository.UserRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Cart> getCartById(String id) {
        if(id != null){
            return cartRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public Iterable<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart createCart(CreateCartInput input) {
        String userId = input.getUserId();
        if(userId == null || userId.isEmpty()){
            throw EntityRuntimeException.entityIdNotNull(User.class);
        }
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> EntityRuntimeException.notFound(User.class, userId));

        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}