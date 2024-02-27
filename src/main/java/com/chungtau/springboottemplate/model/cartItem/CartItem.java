package com.chungtau.springboottemplate.model.cartItem;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.chungtau.springboottemplate.model.cart.Cart;
import com.chungtau.springboottemplate.model.product.Product;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "cartItems")
@QueryEntity
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1507988982L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    private Cart cart;


    private Product product;

    private Integer quantity;

    private Float price;
}
