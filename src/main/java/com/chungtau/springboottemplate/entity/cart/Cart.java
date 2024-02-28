package com.chungtau.springboottemplate.entity.cart;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.cartItem.CartItem;
import com.chungtau.springboottemplate.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@EqualsAndHashCode(callSuper = true) // This tells Lombok to include fields from BaseEntity in equals and hashCode calculations
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "carts")
@QueryEntity
public class Cart extends BaseEntity{
    private static final long serialVersionUID = -155501674L;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}