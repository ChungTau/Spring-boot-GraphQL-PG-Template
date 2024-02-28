package com.chungtau.springboottemplate.entity.cartItem;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.cart.Cart;
import com.chungtau.springboottemplate.entity.product.Product;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "cartItems")
@EqualsAndHashCode(callSuper = true)
@QueryEntity
public class CartItem extends BaseEntity {
    private static final long serialVersionUID = 1507988982L;

    @ManyToOne
    private Cart cart;

    private Product product;

    private Integer quantity;

    private Float price;
}
