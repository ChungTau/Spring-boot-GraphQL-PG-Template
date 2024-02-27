package com.chungtau.springboottemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungtau.springboottemplate.exception.EntityRuntimeException;
import com.chungtau.springboottemplate.model.cart.Cart;
import com.chungtau.springboottemplate.model.cartItem.CartItem;
import com.chungtau.springboottemplate.model.cartItem.CreateCartItem;
import com.chungtau.springboottemplate.model.cartItem.UpdateCartItemQuantityInput;
import com.chungtau.springboottemplate.model.product.Product;
import com.chungtau.springboottemplate.repository.CartItemRepository;
import com.chungtau.springboottemplate.repository.CartRepository;
import com.chungtau.springboottemplate.repository.ProductRepository;

import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Optional<CartItem> getCartItemById(String id) {
        if(id != null){
            return cartItemRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public Iterable<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem createCartItem(CreateCartItem input) {
        String cartId = input.getCartId();
        String productId = input.getProductId();
    
        if (cartId == null || cartId.isEmpty()) {
            throw EntityRuntimeException.entityIdNotNull(Cart.class);
        }
    
        if (productId == null || productId.isEmpty()) {
            throw EntityRuntimeException.entityIdNotNull(Product.class);
        }
    
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Cart cart = optionalCart.orElseThrow(() -> EntityRuntimeException.notFound(Cart.class, cartId));
    
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.orElseThrow(() -> EntityRuntimeException.notFound(Product.class, productId));
    
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(input.getQuantity());
        cartItem.setPrice(input.getPrice());
    
        return cartItemRepository.save(cartItem);
    }
    

    public boolean deleteCartItem(String id) {
        if (id == null || id.isEmpty() || !cartItemRepository.existsById(id)) {
            return false;
        }
    
        cartItemRepository.deleteById(id);
        return true; 
    }
    

    public CartItem updateCartItemQuantity(UpdateCartItemQuantityInput input) {
        Optional<CartItem> optionalCartItem = getCartItemById(input.getId());
        CartItem cartItem = optionalCartItem.orElseThrow(() -> EntityRuntimeException.notFound(CartItem.class, input.getId()));
    
        cartItem.setQuantity(input.getQuantity());
        return cartItemRepository.save(cartItem);
    }
    
}
