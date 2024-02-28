package com.chungtau.springboottemplate.entity.cartItem;

import lombok.Data;

@Data
public class UpdateCartItemQuantityInput {
    private String id;
    private Integer quantity;
}
