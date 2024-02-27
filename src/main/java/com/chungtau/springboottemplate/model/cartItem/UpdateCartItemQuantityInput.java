package com.chungtau.springboottemplate.model.cartItem;

import lombok.Data;

@Data
public class UpdateCartItemQuantityInput {
    private String id;
    private Integer quantity;
}
