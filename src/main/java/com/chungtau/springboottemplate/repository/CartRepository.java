package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.model.cart.Cart;

@GraphQlRepository
public interface CartRepository extends CrudRepository<Cart, String>, QuerydslPredicateExecutor<Cart> {
    
}
