package com.chungtau.springboottemplate.model.cartItem;

import lombok.Data;

@Data
public class CreateCartItem {
    private String cartId;

    private String productId;

    private int quantity;

    private Float price;
}
