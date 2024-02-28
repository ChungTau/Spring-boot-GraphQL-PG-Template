package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.entity.cartItem.CartItem;

@GraphQlRepository
public interface CartItemRepository extends CrudRepository<CartItem, String>, QuerydslPredicateExecutor<CartItem> {
    
}